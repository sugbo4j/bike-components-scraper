package nz.co.sugbo4j.bike_components_scraper.config;

import nz.co.sugbo4j.bike_components_scraper.batch.ProductItemProcessor;
import nz.co.sugbo4j.bike_components_scraper.batch.ProductItemWriter;
import nz.co.sugbo4j.bike_components_scraper.batch.RetailerItemReader;
import nz.co.sugbo4j.bike_components_scraper.model.AFullBikeSet;
import nz.co.sugbo4j.bike_components_scraper.model.scrapeData.Retailer; // Added import
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final RetailerItemReader retailerItemReader;
    private final ProductItemProcessor productItemProcessor;
    private final ProductItemWriter productItemWriter;

    public BatchConfiguration(JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            RetailerItemReader retailerItemReader,
            ProductItemProcessor productItemProcessor,
            ProductItemWriter productItemWriter) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.retailerItemReader = retailerItemReader;
        this.productItemProcessor = productItemProcessor;
        this.productItemWriter = productItemWriter;
    }

    @Bean
    public Job scrapingJob() {
        return new JobBuilder("scrapingJob", jobRepository)
                .start(scrapingStep())
                .build();
    }

    @Bean
    public Step scrapingStep() {
        return new StepBuilder("scrapingStep",
                jobRepository).<Retailer.Product, AFullBikeSet>chunk(10,
                        transactionManager)
                .reader(retailerItemReader)
                .processor(productItemProcessor)
                .writer(productItemWriter)
                .build();
    }
}
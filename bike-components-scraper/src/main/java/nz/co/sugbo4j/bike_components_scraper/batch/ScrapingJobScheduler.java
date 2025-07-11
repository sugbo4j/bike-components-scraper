package nz.co.sugbo4j.bike_components_scraper.batch;

import nz.co.sugbo4j.bike_components_scraper.model.scrapeData.Retailer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableScheduling
public class ScrapingJobScheduler implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(ScrapingJobScheduler.class);

    private final JobLauncher jobLauncher;
    private final ApplicationContext applicationContext;
    private final List<Retailer> retailers;
    private final Job scrapingJob; // Assuming a single job for all retailers for now

    @Autowired
    public ScrapingJobScheduler(JobLauncher jobLauncher,
            ApplicationContext applicationContext,
            List<Retailer> retailers,
            Job scrapingJob) {
        this.jobLauncher = jobLauncher;
        this.applicationContext = applicationContext;
        this.retailers = retailers;
        this.scrapingJob = scrapingJob;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        retailers.stream()
                .filter(Retailer::enabled)
                .forEach(retailer -> {
                    taskRegistrar.addTriggerTask(
                            () -> launchJob(retailer.retailerId()),
                            new CronTrigger(retailer.schedule()));
                    logger.info("Scheduled job for retailer: {} with schedule: {}",
                            retailer.retailerName(), retailer.schedule());
                });
    }

    private void launchJob(String retailerId) {
        Map<String, JobParameters> jobParamsMap = new HashMap<>();
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("retailerId", retailerId)
                .addDate("timestamp", new Date())
                .toJobParameters();

        try {
            jobLauncher.run(scrapingJob, jobParameters);
            logger.info("Launched job for retailer: {}", retailerId);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
                | org.springframework.batch.core.UnexpectedJobExecutionException
                | org.springframework.batch.core.JobParametersInvalidException e) {
            logger.error("Error launching job for retailer {}: {}", retailerId, e.getMessage());
        }
    }
}
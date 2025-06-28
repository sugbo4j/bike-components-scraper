package nz.co.sugbo4j.bike_components_scraper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;

@SpringBootTest
class BikeComponentsScraperApplicationTests {

	@Test
	void contextLoads() {
	}

	@Configuration
	static class TestBatchConfiguration {
		@Bean
		public DataSource dataSource() {
			return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.H2)
					.addScript("classpath:org/springframework/batch/core/schema-h2.sql")
					.build();
		}
	}
}

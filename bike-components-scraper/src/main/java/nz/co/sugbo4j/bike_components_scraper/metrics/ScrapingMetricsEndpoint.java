package nz.co.sugbo4j.bike_components_scraper.metrics;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "scrapingmetrics")
public class ScrapingMetricsEndpoint {

    private Map<String, Object> metrics = new HashMap<>();

    public ScrapingMetricsEndpoint() {
        metrics.put("lastScrapeTime", "N/A");
        metrics.put("successfulScrapes", 0);
        metrics.put("failedScrapes", 0);
    }

    @ReadOperation
    public Map<String, Object> scrapingMetrics() {
        return metrics;
    }

    public void updateLastScrapeTime(String time) {
        metrics.put("lastScrapeTime", time);
    }

    public void incrementSuccessfulScrapes() {
        metrics.compute("successfulScrapes", (k, v) -> ((Integer) v) + 1);
    }

    public void incrementFailedScrapes() {
        metrics.compute("failedScrapes", (k, v) -> ((Integer) v) + 1);
    }
}
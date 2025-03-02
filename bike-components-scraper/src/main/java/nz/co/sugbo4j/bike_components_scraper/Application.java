package nz.co.sugbo4j.bike_components_scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Document doc;

        try {
            doc = Jsoup.connect("https://www.performancebike.com/mountain-bikes-bicycles/c14968").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements items = doc.select("div.item");

        for (Element item : items) {
            // System.out.println(item.select("a.product-click").text());
            System.out.println(item.attribute("data-name").getValue());
            
        }

    }

}

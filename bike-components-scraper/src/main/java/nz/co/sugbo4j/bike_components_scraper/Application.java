package nz.co.sugbo4j.bike_components_scraper;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.BikeBrand;
import nz.co.sugbo4j.bike_components_scraper.model.BottomBracket;
import nz.co.sugbo4j.bike_components_scraper.model.Frame;
import nz.co.sugbo4j.bike_components_scraper.model.Material;
import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.PartsMaker;
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

        Frame frame = new Frame(
                BikeBrand.ALCHEMY,
                Material.ALU,
                Frame.Suspension.HARDTAIL,
                BikeBrand.ALCHEMY.getText(),
                Frame.CableRouting.INTERNAL,
                new BottomBracket(PartsMaker.SHIMANO, "model", "description", BottomBracket.Type.THREADED, "BSA", 73),
                30.9);

    }

}

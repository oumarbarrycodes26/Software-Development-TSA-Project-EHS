import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageAnalyzer {
    private final WebParser parser;

    public ImageAnalyzer(WebParser parser) {
        this.parser = parser;
    }

    public void printImageSummaries() {
        Elements images = parser.getImages();

        if (images.isEmpty()) {
            System.out.println("No images found.");
            return;
        }

        for (Element img : images) {
            String alt = img.attr("alt");
            String src = img.attr("src");

            if (alt.isEmpty()) {
                alt = "Image with no description. File name: " + src;
            }

            System.out.println("- " + alt);
        }
    }
}

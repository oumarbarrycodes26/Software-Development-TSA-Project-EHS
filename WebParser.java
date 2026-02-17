import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebParser {
    private final String url;
    private Document doc;

    public WebParser(String url) {
        this.url = url;
    }

    public void fetch() {
        try {
            doc = Jsoup.connect(url)
                    .userAgent("AccessibleWebReader")
                    .get();

            doc.select("script, style, nav, footer, header, ads").remove();
        } catch (Exception e) {
            System.err.println("Failed to load webpage.");
        }
    }

    public String getReadableText() {
        StringBuilder sb = new StringBuilder();

        for (Element el : doc.select("h1, h2, h3, p, li")) {
            sb.append(el.text()).append("\n\n");
        }

        return sb.toString();
    }

    public Elements getImages() {
        return doc.select("img");
    }
}

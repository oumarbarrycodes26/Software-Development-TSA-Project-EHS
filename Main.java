public class Main {
    public static void main(String[] args) {
        String url = "https://example.com";

        WebParser parser = new WebParser(url);
        parser.fetch();

        System.out.println("===== ACCESSIBLE TEXT =====");
        System.out.println(parser.getReadableText());

        ImageAnalyzer imageAnalyzer = new ImageAnalyzer(parser);
        System.out.println("\n===== IMAGE SUMMARIES =====");
        imageAnalyzer.printImageSummaries();

        ContentSummarizer summarizer = new ContentSummarizer(parser.getReadableText());
        System.out.println("\n===== PAGE SUMMARY =====");
        System.out.println(summarizer.generateSummary());
    }
}

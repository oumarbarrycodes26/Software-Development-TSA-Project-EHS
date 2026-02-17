import java.util.*;

public class ContentSummarizer {
    private final String text;

    public ContentSummarizer(String text) {
        this.text = text;
    }

    public String generateSummary() {
        String[] sentences = text.split("\\.");
        Map<String, Integer> frequency = new HashMap<>();

        for (String sentence : sentences) {
            for (String word : sentence.toLowerCase().split("\\W+")) {
                if (word.length() > 4) {
                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        Arrays.sort(sentences, (a, b) ->
                score(b, frequency) - score(a, frequency)
        );

        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < Math.min(3, sentences.length); i++) {
            summary.append("- ").append(sentences[i].trim()).append(".\n");
        }

        return summary.toString();
    }

    private int score(String sentence, Map<String, Integer> freq) {
        int score = 0;
        for (String word : sentence.toLowerCase().split("\\W+")) {
            score += freq.getOrDefault(word, 0);
        }
        return score;
    }
}

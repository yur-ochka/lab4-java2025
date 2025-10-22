import java.util.ArrayList;
import java.util.List;

// Клас Text складається з масиву речень.
public class Text {
    private final List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        // Замінюємо послідовності пробілів і табуляцій одним пробілом
        text = text.replaceAll("[\\s\\t]+", " ").trim();

        // Розбиваємо на речення за крапками, знаками оклику, питання тощо
        String[] parts = text.split("(?<=[.!?])\\s+");
        for (String part : parts) {
            sentences.add(new Sentence(part));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : sentences) {
            sb.append(s.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}

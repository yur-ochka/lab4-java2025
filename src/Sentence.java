import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Клас Sentence складається з масиву слів та розділових знаків.
public class Sentence {
    private final List<Object> elements = new ArrayList<>(); // Word або Punctuation

    public Sentence(String sentence) {
        Matcher matcher = Pattern.compile("[A-Za-z]+|[.,!?;:]").matcher(sentence);
        while (matcher.find()) {
            String token = matcher.group();
            if (token.matches("[A-Za-z]+")) {
                elements.add(new Word(token));
            } else {
                elements.add(new Punctuation(token.charAt(0)));
            }
        }
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object obj : elements) {
            if (obj instanceof Word) {
                words.add((Word) obj);
            }
        }
        return words;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object e : elements) {
            if (e instanceof Word) {
                sb.append(((Word) e).getWord()).append(" ");
            } else {
                sb.append(((Punctuation) e).getMark()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}

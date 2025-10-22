import java.util.ArrayList;
import java.util.List;

// Клас Word складається з масиву літер.
public class Word {
    private final List<Letter> letters = new ArrayList<>();

    public Word(String word) {
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    public String getWord() {
        StringBuilder sb = new StringBuilder();
        for (Letter l : letters) {
            sb.append(l.getValue());
        }
        return sb.toString();
    }

// Рахує кількість входжень певного символу в слові.
    public int countCharacter(char target) {
        int count = 0;
        for (Letter l : letters) {
            if (Character.toLowerCase(l.getValue()) == Character.toLowerCase(target)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return getWord();
    }
}

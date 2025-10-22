import java.util.ArrayList;
import java.util.List;

//  Основний клас TextProcessor виконує дiю з текстом
public class TextProcessor {

    public static void main(String[] args) {
        try {
            String textInput = "Hello   world,   this is  a sample text with some letters.";
            char targetChar = 'l';

            validateInput(textInput, targetChar);

            Text text = new Text(textInput);
            System.out.println("=== Вхiдний текст ===");
            System.out.println(text);
            System.out.println();

            List<Word> allWords = new ArrayList<>();
            for (Sentence s : text.getSentences()) {
                allWords.addAll(s.getWords());
            }

            if (allWords.isEmpty()) {
                System.out.println("Текст не мiстить слiв.");
                return;
            }

            allWords.sort((w1, w2) -> Integer.compare(
                    w1.countCharacter(targetChar),
                    w2.countCharacter(targetChar)
            ));

            System.out.println("=== Результат сортування ===");
            System.out.printf("%-15s | %s%n", "Слово", "Кiлькiсть '" + targetChar + "'");
            System.out.println("----------------|----------------");
            for (Word w : allWords) {
                System.out.printf("%-15s | %d%n", w.getWord(), w.countCharacter(targetChar));
            }

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    // Перевiряє коректнiсть вхiдних даних.
    private static void validateInput(String text, char targetChar) {
        if (text == null) {
            throw new IllegalArgumentException("Текст не може бути null");
        }
        if (text.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути порожнiм");
        }
        if (!Character.isLetterOrDigit(targetChar)) {
            throw new IllegalArgumentException("Символ має бути лiтерою або цифрою");
        }
    }
}

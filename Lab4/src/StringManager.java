import TextClasses.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code StringManager}  містить методи для виконання завдання
 * з використанням власних класів: в кожному слові заданого тексту,
 * видалити всі попередні входження останньої літери цього слова.
 */
public class StringManager {
    /**
     * Обробляє текст відповідно завданню: в кожному слові заданого тексту,
     * видалити всі попередні входження останньої літери цього слова.
     *
     * @param input вхідний текст у вигляді рядка
     * @return оброблений текст у вигляді рядка
     */
    public String task(String input) {
        // Замінюємо всі послідовності пробілів і табуляцій на один пробіл
        input = input.replaceAll("[\\t ]+", " ");

        // Парсимо текст у відповідні класи
        Text text = parseText(input);

        // Обробляємо кожне слово в тексті
        for (Sentence sentence : text.getSentences()) {
            for (Object element : sentence.getElements()) {
                if (element instanceof Word word) {
                    processWord(word);
                }
            }
        }

        // Повертаємо оброблений текст у вигляді рядка
        return text.toString();
    }

    /**
     * Видаляє всі попередні входження останньої літери слова.
     *
     * @param word слово для обробки
     */
    private void processWord(Word word) {
        if (word.getLetters().isEmpty()) {
            return;
        }

        // Остання літера
        Letter lastLetter = word.getLetters().getLast();
        char lastChar = lastLetter.character();

        // Новий список літер, де всі попередні входження останньої літери видалено
        List<Letter> newLetters = new ArrayList<>();
        for (int i = 0; i < word.getLetters().size() - 1; i++) {
            if (word.getLetters().get(i).character() != lastChar) {
                newLetters.add(word.getLetters().get(i));
            }
        }
        newLetters.add(lastLetter); // Додаємо останню літеру
        word.setLetters(newLetters); // Оновлюємо слово
    }

    /**
     * Парсить текстовий рядок у структуру класів `Text`, `Sentence`, `Word`.
     *
     * @param input вхідний текст у вигляді рядка
     * @return об'єкт класу `Text`, що представляє текст
     */
    private Text parseText(String input) {
        Text text = new Text();

        // Розділяємо текст на речення за допомогою регулярного виразу
        String[] sentenceStrings = input.split("(?<=[.!?])(?=\\s+)");
        for (String sentenceStr : sentenceStrings) {
            Sentence sentence = new Sentence();

            // Розділяємо речення на слова і розділові знаки
            String[] tokens = sentenceStr.split("(?<=[.,!?;:])|(?=[.,!?;:])|\\s+");

            for (String token : tokens) {
                if (token.matches("[.,!?;:]")) {
                    sentence.addPunctuationMark(new PunctuationMark(token.charAt(0)));
                } else if (!token.isEmpty()) {
                    sentence.addWord(new Word(token));
                }
            }

            text.addSentence(sentence);
        }

        return text;
    }
}

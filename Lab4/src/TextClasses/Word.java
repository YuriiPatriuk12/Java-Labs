package TextClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code Word} представляє слово, яке складається з набору літер.
 * Забезпечує методи для отримання, зміни та отримання рядкового представлення слова.
 */
public class Word {
    //Список літер, які складають слово.
    private List<Letter> letters;

    /**
     * Конструктор класу, який створює об'єкт {@code Word},
     * розбиваючи переданий рядок на літери.
     *
     * @param word рядок, який буде представлений як набір {@code Letter}.
     */
    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Повертає список літер, які складають слово.
     *
     * @return {@code List} об'єктів {@code Letter}.
     */
    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Змінює список літер, які складають слово.
     *
     * @param letters новий список об'єктів {@code Letter}.
     */
    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }


    /**
     * Повертає слово у вигляді рядка.
     *
     * @return слово у вигляді рядка {@code String}.
     */
    @Override
    public String toString() {
        String result = "";
        for (Letter letter : letters) {
            result += letter.toString();
        }
        return result;
    }
}

package TextClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code Text} представляє текст, що складається з набору речень.
 * Він забезпечує методи для додавання речень та отримання всього тексту у вигляді рядка.
 */
public class Text {
    //Список, який містить речення, що складають текст.
    private final List<Sentence> sentences;

    /**
     * Конструктор класу.
     */
    public Text() {
        sentences = new ArrayList<>();
    }

    /**
     * Повертає список речень тексту.
     *
     * @return {@code List} об'єктів {@code Sentence}.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Додає речення до тексту.
     *
     * @param sentence об'єкт {@code Sentence}, який необхідно додати.
     */
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }


    /**
     * Повертає текст у вигляді одного рядка.
     *
     * @return текст у вигляді одного рядка {@code String}.
     */
    @Override
    public String toString() {
        String result = "";
        for (Sentence sentence : sentences) {
            result += sentence.toString() + " ";
        }
        return result;
    }
}

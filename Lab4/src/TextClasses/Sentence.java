package TextClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code Sentence} представляє речення, яке складається зі слів
 * та знаків пунктуації. Забезпечує методи для додавання слів і знаків пунктуації.
 */
public class Sentence {
    //Список елементів речення, які можуть бути словами або знаками пунктуації.
    private final List<Object> elements;

    /**
     * Конструктор класу
     */
    public Sentence() {
        elements = new ArrayList<>();
    }

    /**
     * Повертає список елементів речення.
     *
     * @return {@code List} об'єктів, які можуть бути {@code Word} або {@code PunctuationMark}.
     */
    public List<Object> getElements() {
        return elements;
    }

    /**
     * Додає слово до речення.
     *
     * @param word об'єкт {@code Word}, який необхідно додати.
     */
    public void addWord(Word word) {
        elements.add(word);
    }

    /**
     * Додає знак пунктуації до речення.
     *
     * @param mark об'єкт {@code PunctuationMark}, який необхідно додати.
     */
    public void addPunctuationMark(PunctuationMark mark) {
        elements.add(mark);
    }

    /**
     * Перетворює речення у рядок, додаючи пробіли між словами,
     * якщо вони не передують знакам пунктуації.
     *
     * @return рядкове представлення речення {@code String}.
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < elements.size(); i++) {
            Object element = elements.get(i);
            result += element.toString();

            // Якщо елемент є словом
            if (element instanceof Word) {
                // Перевіряємо, чи наступний елемент існує і чи не є він знаком пунктуації
                if (i + 1 < elements.size() && !(elements.get(i + 1) instanceof PunctuationMark)) {
                    result += " ";  // Додаємо пробіл між словами
                }
            }
        }

        return result;
    }
}

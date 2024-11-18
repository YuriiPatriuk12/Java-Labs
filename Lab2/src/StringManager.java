/**
 * Клас {@code StringManager}  містить методи для виконання завдання:
 * В кожному слові заданого тексту, видалити всі попередні входження
 * останньої літери цього слова.
 */
public class StringManager {

    /**
     * Обробляє заданий вхідний рядок, застосовуючи метод {@code removeChar}
     * до кожного слова, зберігаючи пробіли між словами.
     *
     * @param input вхідний рядок, що містить слова, розділені пробілами
     * @return оброблений рядок, де кожне слово змінено за допомогою {@code removeChar}
     */
    public String task(String input) {
        String result = "";

        // Розділяє вхідний рядок на слова та обробляє кожне слово.
        for (String str : input.split(" ")) {
            result += removeChar(str) + " ";
        }

        return result;
    }

    /**
     * В кожному слові заданого тексту, видаляє всі попередні входження
     * останньої літери цього слова, і обробляє розділові знаки та
     * додає їх до результату.
     *
     * @param input слово для обробки
     * @return оброблене слово з видаленими символами
     */
    private String removeChar(String input) {
        String coreWord = input;
        int grammarIndex = 0;

        // Видаляє розділові знаки (якщо вони є) з кінця слова та рахує їх.
        while (!Character.isLetter(coreWord.charAt(coreWord.length() - 1))) {
            coreWord = coreWord.substring(0, coreWord.length() - 1);
            grammarIndex++;
        }

        char elem = coreWord.charAt(coreWord.length() - 1);
        // Видаляє всі входження останнього символу, окрім останнього.
        coreWord = coreWord.substring(0, coreWord.length() - 1)
                .replace(Character.toString(elem), "") + elem;

        // Додає розділові знаки з кінця (якщо вони є).
        return grammarIndex == 0 ? coreWord : coreWord + input.substring(input.length() - grammarIndex);
    }
}

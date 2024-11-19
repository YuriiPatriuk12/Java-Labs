package TextClasses;

/**
 * Клас-запис {@code Letter} представляє окрему літеру.
 * Зберігає символ, який представляє літеру, і забезпечує її рядкове представлення.
 *
 * @param character символ, що представляє літеру.
 */
public record Letter(char character) {

    /**
     * Повертає рядкове представлення літери.
     *
     * @return рядкове представлення {@code String} символу {@code character}.
     */
    @Override
    public String toString() {
        return Character.toString(character);
    }
}

package TextClasses;

/**
 * Клас-запис {@code PunctuationMark} представляє знак пунктуації.
 * Зберігає один символ пунктуації та забезпечує його рядкове представлення.
 *
 * @param mark символ, що представляє знак пунктуації.
 */
public record PunctuationMark(char mark) {

    /**
     * Повертає рядкове представлення знака пунктуації.
     *
     * @return рядкове представлення {@code String} символу {@code mark}.
     */
    @Override
    public String toString() {
        return Character.toString(mark);
    }
}

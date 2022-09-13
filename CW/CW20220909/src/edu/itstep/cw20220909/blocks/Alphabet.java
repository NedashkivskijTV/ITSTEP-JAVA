package edu.itstep.cw20220909.blocks;

public class Alphabet {
    private char[] letters;
    private static final int NUMBER_OF_LETTERS = 26;
    {
        //init letters
        letters = new char[NUMBER_OF_LETTERS];
        char letter = 'a';
        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
            letters[i] = letter++;
        }
    }

    public Alphabet() {
    }

    public char[] getLetters() {
        return letters;
    }
}

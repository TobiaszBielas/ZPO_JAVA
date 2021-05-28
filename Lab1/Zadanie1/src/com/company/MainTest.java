package com.company;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import Lab1.zadanie1.Main;
import org.junit.jupiter.api.Test;

class MainTest {
    private String[] words_1 = {"kot", "drab", "tost", "DEZYNWOLTURA", "skarb", "grom", "grab", "zxcvbn"};
    private String[] words_2 = {"kita", "dal", "stos", "DEZYNWOLTURA", "krab", "grot", "drab", "qwerty"};
    private double[] expected_results = {1.5, 2.0, 2.0, 0.0, 2.5, 1.0, 0.5, 6.0};

    @Test
    void levQWERTY() {
        double[] lev_results = new double[8];
        for(int i=0; i<8; ++i) {
            lev_results[i] = Main.LevQWERTY(words_1[i], words_2[i]);
            System.out.println(words_1[i] + "\n" + words_2[i]);
            System.out.println("expected result:" + expected_results[i] + "\nresult:" + lev_results[i] + "\n");
        }
        Assertions.assertArrayEquals(expected_results, lev_results);
    }
}
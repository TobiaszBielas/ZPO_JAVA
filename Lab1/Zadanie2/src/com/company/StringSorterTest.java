package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.Locale;

class StringSorterTest {
    private String[] data;
    private String[] expected_result = {"Agnieszka", "Darek", "Łukasz", "Órszula",
                                     "Stefania", "Ścibor", "Świętopełk", "Zyta"};
    Locale locale = new Locale("pl", "PL");
    Collator collator = Collator.getInstance(locale);
    private void print(String[] words, String sort_type) {
        System.out.println("\n" + sort_type);
        for(String word : words)
            System.out.print(word + ", ");
    }

    @BeforeEach
    void __init__() {
        data = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek",
                             "Agnieszka", "Zyta", "Órszula", "Świętopełk"};
    }

    @Test
    void sortStrings() {
        StringSorter.sortStrings(collator, data);
        print(data, "sortString");
        assertArrayEquals(expected_result, data);
    }

    @Test
    void fastSortStrings() {
        StringSorter.fastSortStrings(collator, data);
        print(data, "fastSortStrings");
        assertArrayEquals(expected_result, data);
    }

    @Test
    void fastSortStrings2() {
        StringSorter.fastSortStrings2(collator, data);
        print(data, "fastSortStrings2");
        assertArrayEquals(expected_result, data);
    }

    @Test
    void benchmarkTest() {
        System.out.println("Benchmark");
        long start_time, end_time;
        start_time = System.nanoTime();
        for(int i=0; i<100000; ++i) {
            __init__();
            StringSorter.sortStrings(collator, data);
        }
        end_time = System.nanoTime();
        System.out.println("\nsortStrings Time: " + (end_time-start_time));

        start_time = System.nanoTime();
        for(int i=0; i<100000; ++i) {
            __init__();
            StringSorter.fastSortStrings(collator, data);
        }
        end_time = System.nanoTime();
        System.out.println("fastSortStrings Time: " + (end_time-start_time));

        start_time = System.nanoTime();
        for(int i=0; i<100000; ++i) {
            __init__();
            StringSorter.fastSortStrings2(collator, data);
        }
        end_time = System.nanoTime();
        System.out.println("fastSortStrings2 Time: " + (end_time-start_time) + "\n");
    }
}
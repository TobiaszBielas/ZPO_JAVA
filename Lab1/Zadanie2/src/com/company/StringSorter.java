package com.company;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

public class StringSorter {
    public static void sortStrings(Collator collator, String[] words) {
        //insertionSort
        for(int i=0; i<words.length; ++i)
            for(int j=0; j<words.length; ++j)
                if(collator.compare(words[i], words[j]) < 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
    }

    public static void fastSortStrings(Collator collator, String[] words) {
        // Arrays.sort() anonimowy obiekt komparatora
        class  StringComparator implements Comparator<String> {
            public int compare(String word_1, String word_2) {
                return collator.compare(word_1, word_2);
            }
        }

        Arrays.sort(words, new StringComparator());
    }

    public static void fastSortStrings2(Collator collator, String[] words) {
        // Arrays.sort() lambda
        Arrays.sort(words, (word_1, word_2) -> {return collator.compare(word_1, word_2);});
    }
}

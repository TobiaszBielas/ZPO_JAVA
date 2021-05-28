package com.company;

import java.text.Collator;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale locale = new Locale("pl", "PL");
        Collator collator = Collator.getInstance(locale);
        String[] names_insertion = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta",
                "Órszula", "Świętopełk", "Stefan", "Sergiusz", "Stan", "Orion", "Ola"};
        String[] names_test1 = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta",
                "Órszula", "Świętopełk", "Stefan", "Sergiusz", "Stan", "Orion", "Ola"};
        String[] names_test2 = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta",
                "Órszula", "Świętopełk", "Stefan", "Sergiusz", "Stan", "Orion", "Ola"};

        System.out.print("\n\n");
        // InsertionSort
        StringSorter.sortStrings(collator, names_insertion);
        for(String name : names_insertion)
            System.out.print(name + ", ");
        System.out.print("\n\n");

        // Arrays.sort() anonimowy obiekt komparatora
        StringSorter.fastSortStrings(collator, names_test1);
        for(String name : names_test1)
            System.out.print(name + ", ");
        System.out.print("\n\n");

        // Arrays.sort() lambda
        StringSorter.fastSortStrings2(collator, names_test2);
        for(String name : names_test2)
            System.out.print(name + ", ");
    }
}

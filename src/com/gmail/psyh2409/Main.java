package com.gmail.psyh2409;

import com.gmail.psyh2409.ascii.ASCIIart;
import com.gmail.psyh2409.polyglot.Translator;
import com.gmail.psyh2409.task3.WordCounter;

import java.util.*;


public class Main {
    private static Map<Character, List<String>> map = new HashMap<>();
    public static void main(String[] args) {

//        Tasks 1 and 2
        Translator translator = new Translator(
                "dictionary.map",
                "English.in",
                "Ukrainian.out");
        translator.setMap(
                translator.readFromFile().getMap());
        translator.textWriter(
                translator.translateText(
                        translator.textReader()));
        translator.saveToFile();
        System.out.println();

        System.out.println("--------------------------------------------------------");

//        Task 3
        new WordCounter("text.txt");

        System.out.println("________________________________________________________");
        System.out.println();
//        ASCII-art
        ASCIIart ascii = new ASCIIart();
        ascii.printASCII("I love my wife");
    }
}

package com.gmail.psyh2409.task3;

import com.gmail.psyh2409.task3.comparator.ValueComparator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {
    private Map<String, Integer> stat;
    private File file;

    public WordCounter() {
        super();
    }

    public WordCounter(String file) {
        this.stat = new HashMap<>();
        this.file = new File(file);
        this.toSortedLinkedHashMap(this.toClearStringArray(this.fileReader()));
    }

    public Map<String, Integer> getStat() {
        return stat;
    }

    public void setStat(Map<String, Integer> stat) {
        this.stat = stat;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String fileReader() {
        StringBuilder sb = new StringBuilder("");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String s = "";
                while (br.ready()) {
                    s = br.readLine();
                    sb.append(s);
                }
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String[] toClearStringArray(String str) {
        if (str == null) {
            return null;
        }
        String[] strings = str.toLowerCase().replaceAll("\\W", " ").split(" ");
        Arrays.sort(strings);
        return strings;
    }

    public void toSortedLinkedHashMap(String[] strings){
        if (strings == null) { return; }
        stat = new HashMap<>();
        for (String s: strings) {
            if (s.equals("")) continue;
            if (stat.containsKey(s)){
                stat.put(s, stat.get(s)+1);
            }else {
                stat.put(s, 1);
            }
        }
        Comparator<Map.Entry<String, Integer>> comparator = new ValueComparator();
        print(stat.entrySet()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::compareTo, LinkedHashMap::new)));
    }
    public void print(Map<String, Integer> stat){
        for (Map.Entry<String, Integer> entry: stat.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCounter that = (WordCounter) o;
        return Objects.equals(stat, that.stat) &&
                Objects.equals(file, that.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stat, file);
    }

    @Override
    public String toString() {
        return "WordCounter{" +
                "stat=" + stat +
                ", file=" + file +
                '}';
    }
}
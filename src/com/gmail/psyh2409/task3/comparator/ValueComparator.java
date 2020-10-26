package com.gmail.psyh2409.task3.comparator;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if (o1 == null & o2 != null) return -1;
        if (o1 == null & o2 == null) return 0;
        if (o1 != null & o2 == null) return 1;

        if (o1.getValue() > o2.getValue()) return -1;
        if (o1.getValue() == o2.getValue()) return 0;
        if (o1.getValue() < o2.getValue()) return 1;
        return 0;
    }
}

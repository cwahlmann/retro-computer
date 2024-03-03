package de.dreierschach.retrocomputer.basic.model;

import java.util.Comparator;

public class LineComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        var n1 = getLineNumber(o1);
        var n2 = getLineNumber(o2);
        return n2 - n1;
    }

    public static int getLineNumber(String line) {
        int i = 0;
        while (i < line.length() && Character.isDigit(line.charAt(i))) {
            i++;
        }
        return Integer.parseInt(line.substring(0, i));
    }
}

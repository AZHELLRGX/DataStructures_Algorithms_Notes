package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 1078. Bigram 分词
 */
public class OccurrencesAfterBigram {
    public static void main(String[] args) {
        OccurrencesAfterBigram o = new OccurrencesAfterBigram();
        Utils.print(o.findOcurrences("alice is a good girl she is a good student", "a", "good"));
        Utils.print(o.findOcurrences("we will we will rock you", "we", "will"));
        Utils.print(o.findOcurrences("we will we will", "we", "will"));
    }

    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        String[] array = text.split(" ");
        for (int i = 0; i < array.length - 2; i++) {
            if (first.equals(array[i]) && second.equals(array[i + 1])) {
                result.add(array[i + 2]);
            }
        }
        return result.toArray(new String[0]);
    }
}

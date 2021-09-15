package org.azhell.tool;

public class Utils {

    private Utils() {
        // do nothing
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void print(int[] array) {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            s.append(array[i]);
            if (i != array.length - 1) {
                s.append(",");
            }
        }
        s.append("]");
        System.out.println(s);
    }
}

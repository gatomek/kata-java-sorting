package pl.gatomek.sorting;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InsertSorter {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsertSorter.class);

    private static void move(int[] table, int from, int to) {
        table[to] = table[from];
    }

    public static void main(String[] args) {
        final int[] table = {62, 83, 18, 53, 07, 17, 95, 86, 47, 69, 25, 28};
        LOGGER.info(Arrays.toString(table));
        sort(table);
        LOGGER.info(Arrays.toString(table));
    }

    public static void sort(int[] table) {
        final int len = table.length;
        for (int i = 1; i < len; ++i) {
            int value = table[i];

            int curr = i;
            while (curr - 1 >= 0 && value < table[curr - 1]) {
                move(table, curr - 1, curr);
                --curr;
            }

            if (curr != i) table[curr] = value;
        }
    }
}

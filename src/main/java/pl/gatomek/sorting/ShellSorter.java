package pl.gatomek.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// todo: implementing other intervals: Shell, Pratt, Knuth, Sedgewick, Gonnet, Tokuda, Ciura
// todo: performance comparison

public class ShellSorter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShellSorter.class);

    public static void main(String[] args) {
        final int[] table = {62, 83, 18, 53, 07, 17, 95, 86, 47, 69, 25, 28};

        LOGGER.info(Arrays.toString(table));
        wikiSort(table);
        LOGGER.info(Arrays.toString(table));
    }

    public static void wikiSort(int[] table) {
        // https://pl.wikipedia.org/wiki/Sortowanie_Shella
        sort(table, new int[]{5, 3, 1});
    }

    public static void sort(int[] table, int[] steps) {
        final int len = table.length;

        for (int step : steps) {
            for (int s = 0; s < step; ++s) {

                List<Integer> indices = new LinkedList<>();
                for (int i = s; i < len; i += step)
                    indices.add(i);

                final int size = indices.size();
                if (size > 1) {
                    int[] subtable = new int[size];

                    for (int i = 0; i < size; ++i)
                        subtable[i] = table[indices.get(i)];

                    InsertSorter.sort(subtable);

                    for (int i = 0; i < size; ++i)
                        table[indices.get(i)] = subtable[i];
                }
            }
        }
    }
}

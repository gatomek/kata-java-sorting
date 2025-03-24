package pl.gatomek;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;
import pl.gatomek.sorting.InsertSorter;
import pl.gatomek.sorting.ShellSorter;

import java.io.IOException;

public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void shellSortBenchmark(Blackhole blackhole) {
        final int[] table = {
                33, 22, 3, 81, 33, 3, 54, 36, 83, 68,
                55, 31, 80, 47, 57, 79, 61, 45, 17, 88,
                86, 13, 95, 50, 77, 19, 86, 7, 77, 95,
                51, 22, 89, 63, 9, 40, 36, 68, 23, 95,
                89, 65, 15, 91, 60, 65, 33, 83, 61, 58,
                32, 87, 6, 32, 54, 67, 35, 100, 97, 84,
                46, 99, 78, 66, 87, 55, 93, 33, 74, 10,
                46, 3, 85, 18, 8, 85, 5, 28, 76, 82,
                71, 24, 84, 19, 11, 67, 60, 66, 70, 41,
                67, 59, 10, 30, 49, 75, 38, 100, 10, 9

        };
        ShellSorter.wikiSort(table);
        blackhole.consume(blackhole);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void insertSortBenchmark(Blackhole blackhole) {
        final int[] table = {
                33, 22, 3, 81, 33, 3, 54, 36, 83, 68,
                55, 31, 80, 47, 57, 79, 61, 45, 17, 88,
                86, 13, 95, 50, 77, 19, 86, 7, 77, 95,
                51, 22, 89, 63, 9, 40, 36, 68, 23, 95,
                89, 65, 15, 91, 60, 65, 33, 83, 61, 58,
                32, 87, 6, 32, 54, 67, 35, 100, 97, 84,
                46, 99, 78, 66, 87, 55, 93, 33, 74, 10,
                46, 3, 85, 18, 8, 85, 5, 28, 76, 82,
                71, 24, 84, 19, 11, 67, 60, 66, 70, 41,
                67, 59, 10, 30, 49, 75, 38, 100, 10, 9

        };
        InsertSorter.sort(table);
        blackhole.consume(table);
    }
}


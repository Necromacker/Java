import java.util.Random;

public class StringBenchmark {

    // Version 1: String concatenation
    public static String compressV1(String str) {
        StringBuilder newStr = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            newStr.append(str.charAt(i));
            if (count > 1) {
                newStr.append(count.toString());
            }
        }
        return newStr.toString();
    }

    // Version 2: StringBuilder (same logic, returns String instead of printing,
    // so the work can't be skipped and printing time isn't measured)
    public static String compressV2(String str) {
        str += " ";
        int count = 1;
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else if (count == 1) {
                compressed.append(str.charAt(i));
            } else {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 1;
            }
        }
        return compressed.toString();
    }

    // Worst case: no repeated characters (output as long as input)
    static String noRepeats(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++)
            sb.append((char) ('a' + (i % 2 == 0 ? 0 : 1)));
        return sb.toString(); // abab...
    }

    // Best case: one long run
    static String allSame(int n) {
        return "a".repeat(n);
    }

    // Random mix with short runs
    static String randomRuns(int n) {
        Random r = new Random(42);
        StringBuilder sb = new StringBuilder(n);
        while (sb.length() < n) {
            char c = (char) ('a' + r.nextInt(26));
            int run = 1 + r.nextInt(5);
            for (int k = 0; k < run && sb.length() < n; k++)
                sb.append(c);
        }
        return sb.toString();
    }

    interface Compressor {
        String run(String s);
    }

    // Returns average time in milliseconds over `runs` runs
    static double time(Compressor c, String input, int runs) {
        long total = 0;
        int sink = 0; // consume results so the JIT can't discard the work
        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            String out = c.run(input);
            total += System.nanoTime() - start;
            sink += out.length();
        }
        if (sink == -1)
            System.out.println(); // never true
        return total / (double) runs / 1_000_000.0;
    }

    static void benchmark(String label, java.util.function.IntFunction<String> gen, int[] sizes) {
        System.out.println("\n=== " + label + " ===");
        System.out.printf("%-10s %-18s %-18s %-10s%n", "n", "V1 String+= (ms)", "V2 StringBuilder (ms)", "V1/V2");
        for (int n : sizes) {
            String input = gen.apply(n);

            // Sanity check: both versions must produce the same output
            if (!compressV1(input).equals(compressV2(input))) {
                System.out.println("Outputs differ for n=" + n + " !");
            }

            int runs = n <= 10_000 ? 20 : 5;
            // Warm-up so the JIT compiles both methods before timing
            for (int w = 0; w < 3; w++) {
                compressV1(input);
                compressV2(input);
            }

            double t1 = time(StringBenchmark::compressV1, input, runs);
            double t2 = time(StringBenchmark::compressV2, input, runs);
            System.out.printf("%-10d %-18.3f %-18.3f %-10.1fx%n", n, t1, t2, t1 / t2);
        }
    }

    public static void main(String[] args) {
        int[] sizes = { 1_000, 10_000, 50_000, 100_000, 200_000 };

        benchmark("Worst case: no repeats (abab...)", StringBenchmark::noRepeats, sizes);
        benchmark("Random short runs", StringBenchmark::randomRuns, sizes);
        benchmark("Best case: all same character", StringBenchmark::allSame, sizes);
    }
}
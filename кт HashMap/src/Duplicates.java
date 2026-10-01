import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Duplicates {
    //0(n^2)
    public static boolean hasDuplicatesBruteForce(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    // O(n log n)
    public static boolean hasDuplicatesSorting(int[] a) {
        if (a == null || a.length < 2) return false;

        int[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);

        for (int i = 0; i < copy.length - 1; i++) {
            if (copy[i] == copy[i + 1]) {
                return true;
            }
        }
        return false;
    }
    //O(n)
    public static boolean hasDuplicatesHashSet(int[] a) {
        Set<Integer> seen = new HashSet<>();

        for (int x : a) {
            if (!seen.add(x)) {
                return true;
            }
        }
        return false;
    }
    public static boolean hasDuplicates(int[] a, int k) {
        boolean[] seen = new boolean[k + 1];
        for (int x : a) {
            if (x < 0 || x > k) {
                throw new IllegalArgumentException(
                        "Число " + x + " выходит за диапазон [0, " + k + "]"
                );
            }
            if (seen[x]) {
                return true;
            }
            seen[x] = true;
        }
        return false;
    }

}

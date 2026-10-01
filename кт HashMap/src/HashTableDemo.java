import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashTableDemo {

    static int hash(int k, int m) {
        return (11 * k + 4) % m;
    }
    static void openAddressing(int[] keys, int m) {
        Integer[] table = new Integer[m];
        Arrays.fill(table, null);

        for (int k : keys) {
            int h = hash(k, m);
            int i = 0;
            int pos;
            do {
                pos = (h + i) % m;
                if (table[pos] == null) {
                    table[pos] = k;
                    System.out.printf("Ключ %2d -> h=%d, вставлен в ячейку %d%n", k, h, pos);
                    break;
                } else {
                    System.out.printf("Ключ %2d -> h=%d, ячейка %d занята (%d), пробуем %d%n",
                            k, h, pos, table[pos], (pos + 1) % m);
                    i++;
                }
            } while (i < m);

            if (i == m) {
                System.out.println("Таблица переполнена! Не удалось вставить " + k);
                return;
            }
        }

        System.out.println("\nИтоговая таблица:");
        System.out.print("Индекс: ");
        for (int i = 0; i < m; i++) System.out.printf("%4d", i);
        System.out.print("\nКлючи : ");
        for (int i = 0; i < m; i++) {
            System.out.printf("%4s", table[i] == null ? "—" : table[i]);
        }
        System.out.println("\n");
    }


    static void closedAddressing(int[] keys, int m) {
        List<Integer>[] table = new LinkedList[m];
        for (int i = 0; i < m; i++) table[i] = new LinkedList<>();

        for (int k : keys) {
            int h = hash(k, m);
            table[h].add(k);
            System.out.printf("Ключ %2d -> h=%d, добавлен в цепочку %d: %s%n",
                    k, h, h, table[h]);
        }

        System.out.println("\nИтоговая таблица:");
        for (int i = 0; i < m; i++) {
            System.out.printf("  [%d] -> %s%n", i, table[i].isEmpty() ? "O" : table[i]);
        }
        System.out.println();
    }
    public static int calculateSum(String text) {
        int sum = 0;
        for (char c : text.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}

import static java.util.Objects.hash;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Map<String,String> map =new HashMap<>();
    map.put("Никита", "Банан");
    map.put("Анна", "Яблоко");
    map.put("Иван", "Апельсин");
    map.put("Мария", "Виноград");
    map.put("Петр", "Груша");
    map.put("Елена", "Слива");
    map.put("Сергей", "Персик");
    map.put("Ольга", "Абрикос");
    map.put("Дмитрий", "Манго");
    map.put("Ксения", "Киви");
    System.out.println(map);
    Map<String, Integer> hashedMap = new HashMap<>();

    for (Map.Entry<String, String> entry : map.entrySet()) {
        String name = entry.getKey();
        String fruit = entry.getValue();

        int nameHash = HashTableDemo.calculateSum(name);
        int fruitHash = HashTableDemo.calculateSum(fruit);
        int totalHash = nameHash + fruitHash;

        String key = name + " - " + fruit;
        hashedMap.put(key, totalHash);
    }

    System.out.println("Результат хеширования:");
    for (Map.Entry<String, Integer> entry : hashedMap.entrySet()) {
        System.out.println(entry.getKey() + " " + entry.getValue());
    }
    int[] A = {67, 13, 49, 24, 40, 33, 58};
    int m = 9;

    System.out.println("Хеш-функция: h(k) = (11k + 4) mod " + m);
    System.out.println("Значения h(k):");
    for (int k : A) {
        System.out.printf("  h(%d) = %d%n", k, hash(k, m));
    }
    System.out.println();

    HashTableDemo.openAddressing(A, m);
    HashTableDemo.closedAddressing(A, m);
}


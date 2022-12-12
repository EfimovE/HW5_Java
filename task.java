// Создать словарь HashMap. Обобщение <Integer, String>.
// Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)
// Изменить значения дописав восклицательные знаки. *Создать TreeMap, заполнить аналогично.
// *Увеличить количество элементов таблиц до 1000 случайными ключами и общей строкой.
// **Сравнить время прямого и случайного перебора тысячи элементов словарей.

import java.util.*;

public class task {
    public static void main(String[] args) {
        Map<Integer, String> colorsMap = new HashMap<>();
        colorsMap.put(1, "Желтый");
        colorsMap.put(2, "Белый");
        colorsMap.put(3, "Черный");
        colorsMap.putIfAbsent(4, "Синий");
        for (int i: colorsMap.keySet()) {
            colorsMap.compute(i,(k, v) -> v = v + "!");
        }
        System.out.println(colorsMap);


        Map<Integer, String> colorsMap2 = new TreeMap<>();
        colorsMap2.put(1, "Желтый");
        colorsMap2.put(2, "Белый");
        colorsMap2.put(3, "Черный");
        colorsMap2.putIfAbsent(4, "Синий");


        for (int i = 0; i < 1000; i++) {
            int rand = new Random().nextInt(10000);
            colorsMap.put(rand, " ");
        }
        for (int i = 0; i < 1000; i++) {
            int rand = new Random().nextInt(10000);
            colorsMap2.put(rand, " ");
        }

        long start = System.currentTimeMillis();
        colorsMap.forEach((k,v) -> System.out.print(k + v));
        System.out.println("HashMap: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        colorsMap2.forEach((k,v) -> System.out.print(k + v));
        System.out.println("TreeMap: " + (System.currentTimeMillis() - start));

    }
}
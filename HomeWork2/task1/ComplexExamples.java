import java.util.*;
import java.util.stream.Collectors;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        /*
        Task1
        Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

        Что должно получиться
        Key: Amelia
        Value:4
        Key: Emily
        Value:1
        Key: Harry
        Value:3
        Key: Jack
        Value:1
*/

        Map<String, List<Person>> map = setMap(RAW_DATA);
        sortedMap(map);
/*
    Результат метода сверху
        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)

        Emily:
        1 - Emily (3)

        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)

        Jack:
        1 - Jack (4)
*/


        resultTask(map);
/*
    Результат метода сверху
        Key: Amelia
        Value: 4
        Key: Emily
        Value: 1
        Key: Harry
        Value: 3
        Key: Jack
        Value: 1
*/

        sumPair();
        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */



        /*
        Task3
            Реализовать функцию нечеткого поиска
            
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */


    }

    private static void sumPair() {
        Scanner in = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();
        array.add(in.nextInt());
        array.add(in.nextInt());
        array.add(in.nextInt());
        array.add(in.nextInt());
        int sum = in.nextInt();

        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - 1; j++) {

            }
        }

        System.out.println(array.toString() + sum);

    }

    private static void resultTask(Map<String, List<Person>> map) {
        if (map.size() == 0) {
            System.out.println("Empty");
        } else {
            map.forEach(
                    (key, value) -> {
                        int countName = getCountName(value);
                        System.out.println("Key: " + key + "\nValue: " + countName);
                    }
            );
        }
    }

    private static int getCountName(List<Person> value) {
        return value.size();
    }

    private static void sortedMap(Map<String, List<Person>> map) {
        if (map.size() == 0) {
            System.out.println("Empty");
        } else {
            map.forEach(
                    (key, value) -> {
                        String name = convertValue(value);
                        System.out.println(key + ":\n" + name);
                    }
            );
        }
    }

    private static String convertValue(List<Person> value) {
        ArrayList<String> name = value.stream()
                .map((person) -> person.name + " (" + person.id + ")\n")
                .collect(Collectors.toCollection(ArrayList::new));
        int j = 1;
        for (int i = 0; i < name.size(); i++) {
            name.set(i, j + " - " + name.get(i));
            j++;
        }
        return String.join("", name);
    }

    private static Map<String, List<Person>> setMap(Person[] listPerson) {
        return Arrays.stream(listPerson).sorted(Comparator.comparing(o -> o.id)).distinct().collect(Collectors.groupingBy(Person::getName));
    }
}

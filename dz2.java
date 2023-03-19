import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class dz2 {
    public static void main(String[] args) {
        String[] people = new String[] { "Олег Иванов", "Ирина Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Иван Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова", "Александра Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Олег Мечников", "Петр Петин", "Иван Ежов" };

        Map<String, Integer> names = new HashMap<>();
        for (String person : people) {
            String name = person.split(" ")[0];
            if (!names.containsKey(name))
                names.put(name, 1);
            else
                names.put(name, names.get(name) + 1);
        }

        names.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(person -> System.out.println("Имя \"" + person.getKey() + "\" в количестве " +
                        person.getValue() + " шт"));
    }
}
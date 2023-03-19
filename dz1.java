import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class dz1 {

    private static Scanner input = new Scanner(System.in,"cp866");

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();

        int stop = 0;
        while (stop != 3) {
            System.out.print(
                    "\n1 - посмотреть телефонный справочник \n2 - создать новый контакт или  добавить номер в существующий контакт \n3 - завершить \n\nВведите цифру: ");
            stop = Integer.parseInt(input.next());
            
            switch (stop) {
                case 1:
                    printPhoneBook(map);
                    break;
                case 2:
                    createOrUpdateContact(map);
                    break;
                default:
                    stop = 3;
                    break;
            }

        }

    }

    private static void printPhoneBook(Map<String, List<String>> phoneB) {
        for (Entry<String, List<String>> entry : phoneB.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
        }
    }

    private static void createOrUpdateContact(Map<String, List<String>> phoneB) {

        System.out.print("Введите фамилию абонента с большой буквы: ");
        String firstname = input.next();
        if (phoneB.containsKey(firstname)) {
            System.out.print("Такой абонент существует! \n1 - добавить еще номер к существующему контакту\n" +
                    "2 - добавить другого абонента (измените имя)\n");
            int whatDo = input.nextInt();
            if (whatDo == 1) {
                System.out.print("Введите номер: ");
                String phone = input.next();
                ArrayList<String> oldPhone = new ArrayList<>(phoneB.get(firstname));
                oldPhone.add(phone);
                phoneB.put(firstname, oldPhone);
                printPhoneBook(phoneB);
            }
            if (whatDo == 2)
                createOrUpdateContact(phoneB);
        } else {
            System.out.print("Введите номер: ");
            String phone = input.next();
            phoneB.put(firstname, Arrays.asList(phone));
            System.out.println("Контакт добавлен!");
            printPhoneBook(phoneB);
        }

    }

}
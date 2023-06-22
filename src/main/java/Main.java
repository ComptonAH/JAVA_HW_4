

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner entering = new Scanner(System.in);
        List<List> complete_data = new ArrayList<>();
        while (true) {

            System.out.print("Enter the name: ");
            String name = entering.nextLine();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);

            System.out.print("Enter the surname: ");
            String surname = entering.nextLine();
            surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);

            System.out.print("Enter the patronymic: ");
            String patronymic = entering.nextLine();
            patronymic = patronymic.substring(0, 1).toUpperCase() + patronymic.substring(1);

            System.out.print("Enter the age: ");
            String age = entering.nextLine();
            age = String.valueOf(Integer.parseInt(age));
            age = Integer.toString(Integer.parseInt(age));

            System.out.print("Enter the sex: ");
            String sex = entering.nextLine().toLowerCase();

            List<String> data = new ArrayList<>();
            data.add(name);
            data.add(surname);
            data.add(patronymic);
            data.add(age);
            data.add(sex);
            complete_data.add(data);
            System.out.print("Enter 'Q' to exit the filling the list up or any other symbol to continue the adding: ");
            String symbol = entering.nextLine().toLowerCase();
            if (symbol.equals("q")) {
                System.out.println(complete_data);
                break;
            }
        }
        System.out.print("Enter 'Q' one more time to close the program or enter 'S' to sort the data: ");
        String symbol = entering.nextLine().toLowerCase();
        switch (symbol) {
            case ("q"):
                System.out.println("The program has been closed");
            case ("s"):
                System.out.print("Which type do you want to use to sort by? ('A' - age, 'G' - by sex and age):  ");
                String by = entering.nextLine().toLowerCase();
                switch (by) {
                    case ("a"):
                        complete_data.sort(new Comparator<List>() {
                            @Override
                            public int compare(List o1, List o2) {
                                Integer age_1 = Integer.parseInt((String) o1.get(3));
                                Integer age_2 = Integer.parseInt((String) o2.get(3));
                                return age_1 - age_2;
                            }
                        });
                        System.out.println(complete_data);
                        System.out.println("The programm has been closed");

                    case ("g"):
                        complete_data.sort(new Comparator<List>() {
                            @Override
                            public int compare(List o1, List o2) {
                                String s_i = (String) o1.get(4);
                                String s_i1 = (String) o2.get(4);

                                if (s_i.equals("f") && s_i1.equals("m")) {
                                    return -1;
                                } else if (s_i.equals("m") && s_i1.equals("f")) {
                                    return 1;
                                } else {
                                    return 0;
                                }
                            }
                        });
                        complete_data.sort(new Comparator<List>() {
                            @Override
                            public int compare(List o1, List o2) {
                                String s_i = (String) o1.get(4);
                                String s_i1 = (String) o2.get(4);

                                Integer age_1 = Integer.parseInt((String) o1.get(3));
                                Integer age_2 = Integer.parseInt((String) o2.get(3));

                                if (s_i.equals(s_i1)){
                                    return age_1 - age_2;
                                } else {
                                    return 0;
                                }
                            }
                        });
                        System.out.println(complete_data);
                        System.out.println("The programm has been closed");
                }
        }
    }
}
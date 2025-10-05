package Home_Works;

import java.util.Scanner;
public class Amantai_Jumabaev_HW_1 {
    public static void main(String[] args) {

        // 1. и 4.
        String gradeForTask ;
        final int num = 100;
        String word = "% complete";
        gradeForTask = num + word;

        // 5.
        System.out.println(gradeForTask);
        System.out.println(num);
        System.out.println(word);

        // 6.
        if (num < 0) {
            System.out.println("Вы сохранили отрицательное число");
        } else if (num > 0) {
            System.out.println("Вы сохранили положительное число");
        } else {
            System.out.println("Вы сохранили ноль");
        }

        // 7.
        System.out.print("Введите ваше имя: ");

        // 8. и 9.
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");
    }
}

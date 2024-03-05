package ru.yandex.practicum.liza;

import java.util.Scanner;
import static ru.yandex.practicum.liza.utils.Printer.print;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var stepTracker = new StepTracker(scanner);

        var exit = false;
        while (!exit) {
            printMenu();
            int actionNumber = scanner.nextInt();
            switch (actionNumber) {
                case 1 -> stepTracker.addNewNumberStepsPerDay();
                case 2 -> stepTracker.changeStepGoal();
                case 3 -> stepTracker.printStatistic();
                case 4 -> exit = true;
                default -> print("������: ����������� �������\n");
            }
        }
    }

    private static void printMenu() {
        print("""
                �������� ���� �� ������:
                1. ������ ���������� ����� �� ����������� ����
                2. �������� ���� �� ���������� ����� � ����
                3. ���������� ���������� �� ����������� �����
                4. ����� �� ����������""");
    }
}
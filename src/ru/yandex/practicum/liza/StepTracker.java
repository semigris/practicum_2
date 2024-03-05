package ru.yandex.practicum.liza;// ������ �� ���������� � ��������� ���������� �����, ����� ����������.
import java.util.Scanner;

import static ru.yandex.practicum.liza.utils.Printer.print;

public class StepTracker {

    private final MonthData[] monthToData = new MonthData[12];
    private final Converter converter = new Converter();
    private final Scanner scanner;
    private int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan){
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        print("������� ����� ������ �� 1 �� 12");
        var monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            print("������: ����� ��������� ������ ������ ���� �� 1 �� 12\n");
            return;
        }
        print("������� ���� �� 1 �� 30");
        var dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {
            print("������: ����� ��������� ��� ������ ���� �� 1 �� 30\n");
            return;
        }
        print("������� ���������� �����");
        var stepsAmount = scanner.nextInt();
        if (stepsAmount < 0) {
            print("������: ���������� ����� ������ ���� ������������� ������\n");
            return;
        }

        // ���������� ����� � ���������� ����
        MonthData monthForAddData = monthToData[--monthNumber];
        monthForAddData.days[--dayNumber] = stepsAmount;
    }

    void changeStepGoal() {
        print("������ ���� " + goalByStepsPerDay + ". ������� ����� ���� �� ���������� ����� � ����:");
        int newGoalByStepsPerDay = scanner.nextInt();
        if (newGoalByStepsPerDay < 0) {
            print("������: ���������� ����� ������ ���� ������������� ������\n");
            return;
        }
        goalByStepsPerDay = newGoalByStepsPerDay;
    }

    void printStatistic() {
        print("������� ����� ������, ��� �������� ���������� ����������");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            print("������: ����� ��������� ������ ������ ���� �� 1 �� 12\n");
        } else {
            innerStats(monthNumber);
        }
    }

    private void innerStats(int monthNumber) {
        print("���������� �� " + monthNumber + " �����");
        monthToData[monthNumber - 1].printDaysAndStepsFromMonth();
        int sumSteps = monthToData[monthNumber - 1].sumStepsFromMonth();
        print("����� ���������� �����: " + sumSteps);
        print("������������ ���������� �����: " + monthToData[monthNumber - 1].maxSteps());
        print("������� ���������� �����: " + (sumSteps / monthToData[monthNumber - 1].days.length));
        print("���������� ��������� (� ����������): " + converter.convertToKm(sumSteps));
        print("���������� �������� �����������: " + converter.convertStepsToKilocalories(sumSteps));
        print("������������ �����: " + monthToData[monthNumber - 1].bestSeries(goalByStepsPerDay));
        print("");
    }
}
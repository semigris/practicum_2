package ru.yandex.practicum.liza;

import java.util.Arrays;

import static ru.yandex.practicum.liza.utils.Printer.print;

/**
 * �������� ������ ����������� ������ � ������ �� �������� ����������.
 */
public class MonthData {
    int[] days = new int[30];

    /**
     * ����� �� ����� ��������� ������� � ������ �������
     */
    void printDaysAndStepsFromMonth() {
        print("���������� ���������� ����� �� ����:");
        for (int i = 1; i <= days.length; i++) {
            print(i + " ����: " + days[i]);
        }
    }

    /**
     * ������� ����� ����� �� �����
     */
    int sumStepsFromMonth() {
        return Arrays.stream(days).sum();
    }

    /**
     * ������������ ���������� ����� �� �����
     */
    int maxSteps() {
        return Arrays.stream(days).min().orElse(0);
    }

    /**
     * ����� ������������ ����� (������������ ���������� ������ ������ ���������)
     */
    int bestSeries(int goalByStepsPerDay) {
        var currentSeries = 0;
        var finalSeries = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
            } else if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
                currentSeries = 0;
            }
        }
        return Math.max(currentSeries, finalSeries);
    }
}

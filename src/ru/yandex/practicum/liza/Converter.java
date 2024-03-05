package ru.yandex.practicum.liza;

/**
 * �������� �������������� ����� � ��������� � �����������
 */
public class Converter {

    /**
     * ������� ���������� ����� � ��������� (1 ��� = 75 ��)
     */
    int convertToKm(int steps) {
        return steps * 75 / 100_000;
    }

    /**
     * ������� ���������� ����� � ����������� (1 ��� = 50 ���; 1 ���� = 1000 ���)
     */
    int convertStepsToKilocalories(int steps) {
        return steps * 50 / 1000;
    }
}

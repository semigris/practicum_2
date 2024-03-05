// Хранение данных конкретного месяца и логика по подсчёту статистики.
public class MonthData {
    int[] days = new int[30];

    //вывод на экран элементов массива в нужном формате
    void printDaysAndStepsFromMonth() {
        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i]);
        }
    }

    //подсчёт суммы шагов за месяц
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    //максимальное количество шагов за месяц
    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    //поиск максимальной серии (максимальное количество подряд идущих элементов)
    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
                currentSeries = 0;
            }
        }
        if (currentSeries > finalSeries) {
            finalSeries = currentSeries;
        }
        return finalSeries;
    }
}

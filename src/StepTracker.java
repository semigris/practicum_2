// Логика по сохранению и изменению количества шагов, вывод статистики.
import java.util.Scanner;
public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    Scanner scanner;
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan){
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("ВВЕДИТЕ НОМЕР МЕСЯЦА ОТ 1 ДО 12");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("ОШИБКА: Номер вводимого месяца должен быть от 1 до 12\n");
            return;
        }
        System.out.println("ВВЕДИТЕ ДЕНЬ ОТ 1 ДО 30");
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("ОШИБКА: Номер вводимого дня должен быть от 1 до 30\n");
            return;
        }
        System.out.println("ВВЕДИТЕ КОЛИЧЕСТВО ШАГОВ");
        int stepsAmount = scanner.nextInt();
        if (stepsAmount < 0) {
            System.out.println("ОШИБКА: Количество шагов должно быть положительным числом\n");
            return;
        }

        // Добавление шагов в конкретный день
        MonthData monthForAddData = monthToData[--monthNumber];
        monthForAddData.days[--dayNumber] = stepsAmount;
    }

    void changeStepGoal() {
        System.out.println("СТАРАЯ ЦЕЛЬ " + goalByStepsPerDay + ". ВВЕДИТЕ НОВУЮ ЦЕЛЬ ПО КОЛИЧЕСТВУ ШАГОВ В ДЕНЬ:");
        int newGoalByStepsPerDay = scanner.nextInt();
        if (newGoalByStepsPerDay < 0) {
            System.out.println("ОШИБКА: Количество шагов должно быть положительным числом\n");
            return;
        }
        goalByStepsPerDay = newGoalByStepsPerDay;
    }

    void printStatistic() {
        System.out.println("ВВЕДИТЕ НОМЕР МЕСЯЦА, ДЛЯ КОТОРОГО НЕОБХОДИМА СТАТИСТИКА");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("ОШИБКА: Номер вводимого месяца должен быть от 1 до 12\n");
        } else {
            System.out.println("СТАТИСТИКА ЗА " + monthNumber + " МЕСЯЦ");
            monthToData[monthNumber - 1].printDaysAndStepsFromMonth();
            int sumSteps = monthToData[monthNumber - 1].sumStepsFromMonth();
            System.out.println("Общее количество шагов: " + sumSteps);
            System.out.println("Максимальное количество шагов: " + monthToData[monthNumber - 1].maxSteps());
            System.out.println("Среднее количество шагов: " + (sumSteps / monthToData[monthNumber - 1].days.length));
            System.out.println("Пройденная дистанция (в километрах): " + converter.convertToKm(sumSteps));
            System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
            System.out.println("Максимальная серия: " + monthToData[monthNumber - 1].bestSeries(goalByStepsPerDay));
            System.out.println();
        }
    }
}
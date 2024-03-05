import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int actionNumber = scanner.nextInt();
            if (actionNumber == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (actionNumber == 2) {
                stepTracker.changeStepGoal();
            } else if (actionNumber == 3) {
                stepTracker.printStatistic();
            } else if (actionNumber == 4) {
                break;
            } else {
                System.out.println("ОШИБКА: Неизвестная команда\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("ВЫБЕРИТЕ ОДНУ ИЗ КОМАНД:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
    }
}
// Алгориим преобразования шагов в километры и килокалории
public class Converter {

    // перевод количества шагов в километры (1 шаг = 75 см)
    int convertToKm(int steps) {
        return ((steps * 75) / 100000);
    }

    // перевод количества шагов в килокалории (1 шаг = 50 кал; 1 ккал = 1000 кал)
    int convertStepsToKilocalories(int steps) {
        return ((steps * 50) / 1000);
    }
}

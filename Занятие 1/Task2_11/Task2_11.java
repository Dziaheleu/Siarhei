public class Task2_11 {
    public static void main(String[] args) {
        int mas[] = {0, 2, 5, 7, 9, 11,};
        int x;
        for (int i = 0; i < mas.length; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                x = (mas[i] + mas[j]) / 2;
                mas[i] = x;
                System.out.print(mas [i] + " ");
            }
        }
    }
} //////////  Здаюсь! Дальше ничего не выходит...
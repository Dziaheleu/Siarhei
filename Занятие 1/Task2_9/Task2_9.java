public class Task2_9 {
    public static void main(String[] args) {
        int mas[] = {0, 2, 5, 7, 9, 11};
        int max = mas[0];
        int x = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > max) {
                max = mas[i];
                x++;
            }
        }
        System.out.println("Номер максимального значения = " + x);
        int min = mas[0];
        int y = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min) {
                min = mas[i];
                y++;
            }
        }
        System.out.println("Номер минимального значения = " + y);
    }
}

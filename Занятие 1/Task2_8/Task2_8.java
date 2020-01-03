public class Task2_8 {
    public static void main(String[] args) {
        int mas[] = {0, 2, 5, 7, 9, 11};
        int max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > max)
                max = mas[i];
        }
            System.out.println("Мааксимальное значение = " + max);
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min)
                min = mas[i];
        }
        System.out.println("Минимальное значение = " + min);
    }
}

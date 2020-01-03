public class Task2_6 {
    public static void main(String[] args) {
        int mas[] = {0, 2, 5, 7, 9, 11};
        for (int i = 0; i < mas.length; i++) {
            for (int j = i + 2; j < mas.length; j++) {
                int temp = mas[i];
                mas[i] = mas[j];
                mas[j] = temp;
            }
            System.out.print(mas[i] + " ");
        }
    }
}
public class Task2_1 {
    public static void main(String[] args) {
        int mas[] = {0, 2, 5, 7, 9, 11};
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            System.out.print(mas[i] + " ");
        }
    }
}
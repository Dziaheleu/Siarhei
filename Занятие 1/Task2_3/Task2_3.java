public class Task2_3 {
    public static void main(String[] args) {
        int mas[] = {0, 2, 5, 7, 9, 11};
        for (int i = 2; i < mas.length; i = i + 3) {
            System.out.print(mas[i] * 2 + " ");
        }
        int i = -1;
        while (i < mas.length) {
            i = i + 3;
            System.out.print(mas[i] * 2 + " ");
        }
    }
}
      
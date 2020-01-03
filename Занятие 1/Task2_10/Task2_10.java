public class Task2_10 {
    public static void main(String[] args) {
        int mas[] = {0, 2, 5, 7, 9, 11,};
        for (int i = 0; i < mas.length; i++) {
            if (i > 0) {
                if (mas[i - 1] >= mas[i]) {
                    System.out.println("Массив невозрастающий");
                    break;
                }
                if (i == mas.length - 1)
                    System.out.println("Массив  возрастающий");
            }
        }
    }
}
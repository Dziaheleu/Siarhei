public class Task2_4 {
    public static void main(String[] args) {
        int mas[] = {0, 2, 5, 7, 9, 11};{
        int n = 0;
        for (int i = 0; i < mas.length; i++)
            if (mas[i] == 0) {
                n = n + 1;
            }
            if (n > 0)
                System.out.println("Количество нулевых элементов = " + n);
            else
                System.out.println("Нулеых элементов не найдено");
        }
    }
}
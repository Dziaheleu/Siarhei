public class Task2_5 {
    public static void main(String[] args) {
        int mas[] = {0, 2, 5, 7, 9, 11};
        int x = 0;
        int num = -1;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == x)
                num = i;
        }
        if (num == -1)
            System.out.println("Элемент с таким значением не найден.");
        else
            System.out.println("Номер элемента нулевого значения = " + num);
    }
}

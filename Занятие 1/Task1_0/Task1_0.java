public class Task1_0 {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        int x = 10 + i++;   // увеличение значения переменной происходит после того, как ее значение использовали в выражении
        int y = 10 + ++j;   // когда знаки стоят до переменной, сначала увеличивается значение, а потом используется в выражении
        System.out.println("x=" + x);
        System.out.println("y=" + y);
    }
}

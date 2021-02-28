public class ErrorChecking {

    public static void main(String[] args) {
        System.out.println("Метод Main успешно запущен");
        method1();
        System.out.println("Метод Main заканчивает свою работу");
    }

    static void method1() {
        try {
            System.out.println("Первый метод передаёт привет!");
            method2();
        } catch (ArithmeticException err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
        }
    }

    static void method2() throws ArithmeticException {
        int x = 10;
        int y = 0;
        double z = x / y;
        System.out.println(z);
        System.out.println("Второй метод");
    }
}

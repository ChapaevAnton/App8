import java.io.FileNotFoundException;
import java.io.IOException;

public class MyException  {


    //QUESTION: 28.02.2021 https://androidskillfactory.slack.com/archives/C018L96MEUV/p1614497051046600
    // TODO: 28.02.2021 Есть метод, в котором есть блок try-catch-finally. В блоке try возвращается 1,
    //  в catch — 2, finally — 3. Какое значение вернется в итоге выполнения метода?
    //  Правильный ответ:  3. Вернется то значение, которое находится в блоке finally — 3 .
    public static String someMethod() {

        //TODO 10.5
        String str = "test"; //проверка что catch срабатывает

        try {

            // TODO: 28.02.2021 10.5
            System.exit(0);
            return str;
            //throw new NullPointerException();

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return str = str + "catch";
        } finally {
            return str + "finally";
        }
    }

    public static void readFromFile() throws IOException {
        System.out.print("Reading line ");
    }

    public static void main(String[] args) {

        // TODO: 28.02.2021 10.5 в любом случае отобразится на экране исключение, которое выбрасывается в блоке finally.
        try {
            throw new ArithmeticException();
        } catch (ArithmeticException err) {
            throw new NullPointerException();
        } finally {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException err) {
                throw new IndexOutOfBoundsException();
            } finally {
                System.out.println("!!!!");
                throw new ArithmeticException();
            }
        }


        //System.out.println(someMethod());


// TODO: 28.02.2021 10.4.2

//        try {
//            readFromFile();
//        } catch (IOException /*| FileNotFoundException*/ e) {
//            e.printStackTrace();
//        }
//
//        System.out.print("Done");


        // TODO: 28.02.2021 10.4

//        int z = 10;
//        int w = 5;
//
//        try {
//            if (w == 0) throw new CustomArithmeticException("Деление на ноль");
//            int result = z / w;
//            System.out.println(result);
//        } catch (CustomArithmeticException err) {
//            System.out.println(err.getMessage());
//        }

//TODO 10.2.1
        //ArithmeticException
//        int x = 5 / 0;
//
//        //ArrayIndexOutOfBoundsException
//        int[] y = {1, 2, 3, 4, 5};
//        x = y[5];
//
//        //ArrayStoreException
//        Integer a = 10;
//        Object[] b = new String[10];
//        b[0] = a;
//
//        //ClassCastException
//        Object str1 = 10;
//        System.out.println((String) str1);
//
//        //NegativeArraySizeException
//        int[] z = new int[-100];
//
        //NullPointerException
//        String str = null;
//        str.length();
//
//        //NumberFormatException
//        str = "abc";
//        x = Integer.parseInt(str);
//
//        //StringIndexOutOfBoundsException
//        char c = str.charAt(5);
//        System.out.println(c);

    }

}

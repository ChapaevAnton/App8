public class MyException {
    public static void main(String[] args) {


        //TODO 10.2.1
        //ArithmeticException
        int x = 5 / 0;

        //ArrayIndexOutOfBoundsException
        int[] y = {1, 2, 3, 4, 5};
        x = y[5];

        //ArrayStoreException
        Integer a = 10;
        Object[] b = new String[10];
        b[0] = a;

        //ClassCastException
        Object str1 = 10;
        System.out.println((String) str1);

        //NegativeArraySizeException
        int[] z = new int[-100];

        //NullPointerException
        String str = null;
        str.length();

        //NumberFormatException
        str = "abc";
        x = Integer.parseInt(str);

        //StringIndexOutOfBoundsException
        char c = str.charAt(5);
        System.out.println(c);

    }

}

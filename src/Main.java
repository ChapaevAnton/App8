import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(new OneZeroStream());
//
//       for (int i = 0; i < 10; i++) {
//
//            System.out.print(scanner.nextInt());
//        }


        MyLocalClass myLocalClass = new MyLocalClass();

        //вызвать без лямбда
        LocalStringer localStringer = myLocalClass.getStringer();
        System.out.println(localStringer.getString("привет"));
        //если попытаться в одно строку
        System.out.println((myLocalClass.getStringer()).getString("привет"));


        //вызвать с лямбда
        System.out.println(myLocalClass.getStringerLambda.getString("привет"));

        //но можно лямбда прямо в интерфейс воткнуть
        System.out.println(LocalStringer.getStringerLambda.getString("привет"));


        System.out.println(countString(LocalStringer.getStringerLambda));
    }

    static int countString(LocalStringer str) {
        return str.getString("привет").length();
    }





}

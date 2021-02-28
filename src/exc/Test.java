//QUESTION: 28.02.2021 10.4.5 https://androidskillfactory.slack.com/archives/C018L96MEUV/p1614502581048000
package exc;

class A extends Exception {
}

class B extends A {
}

class Ci extends B {
}

class D extends A {
}

class F extends D {
}

class G extends D {
}

class E extends A {
}

class H extends E {
}

public class Test {

    public static void main(String[] args) {


        try {
           throw new Ci();

        } catch (B err) {
            System.out.println("ERROR");
        }

        try {
            throw new D();

        } catch (D err) {
            System.out.println("ERROR");
        }

        try {
            throw new G();

        } catch (A err) {
            System.out.println("ERROR");
        }

        try {
            throw new H();

        } catch (E err) {
            System.out.println("ERROR");
        }

    }
}
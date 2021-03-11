public class MyLocalClass {

    //дедушка функционального интерфейса без лямбда
    LocalStringer getStringer() {
        class LocalClass implements LocalStringer {
            @Override
            public String getString(String str) {
                return str;
            }
        }
        return new LocalClass();
    }

    //функциональный интерфейс с лямбда
    LocalStringer getStringerLambda = str -> str;

}

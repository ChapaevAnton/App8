@FunctionalInterface
public interface LocalStringer {

    String getString(String str);


    LocalStringer getStringerLambda = str -> str;

}

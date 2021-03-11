package practicaltask;

public class Main {
    // TODO: Задание - не изменяя состав рецептов, параметры методов создания и
    //  разогрева гамбургеров в классе Main(метод main) - запустить технологический процесс на кухне.
    //  1.Доработайте исключение OvenException() в классе OvenException - убрав ошибку компиляции...
    //  2.Сделайте процесс работоспособным, используя в Main конструкции try catch finally
    //  3.Сообщи выводом в консоль повару, какого именно характера происходит сбой - что бы он был в курсе нарушений в технологии.
    //  4.Постарайтесь выполнить практическое задание не прибегаю к координальному изменению классов: Hamburger, HamburgerMaker, Oven, Food.
    //  Удачи!!!

    //рецепты
    final static String[] RECIPE = {"булочка белая", "говядина", "огурчики", "кетчуп"};
    final static String[] RECIPE_1 = {"булочка белая", "говядина", "огурчики"};
    final static String[] RECIPE_2 = {"булочка белая", "говядина", "огурчики", "кетчуп", "лук"};
    final static String[] RECIPE_3 = {null, "говядина", "огурчики", null};
    final static String[] RECIPE_4 = {"булочка белая", "говядина", "огурчики", "кетчуп"};

    public static void main(String[] args) {

        //создаем гамбургеры по рецептам
        Food hamburger = HamburgerMaker.make(RECIPE);
        Food hamburger1 = HamburgerMaker.make(RECIPE_1);
        Food hamburger2 = HamburgerMaker.make(RECIPE_2);
        Food hamburger3 = HamburgerMaker.make(RECIPE_3);
        Food hamburger4 = HamburgerMaker.make(RECIPE_4);


        //разогреваем
        Oven.reheatFood(hamburger, 80);
        Oven.reheatFood(hamburger1, 100);
        Oven.reheatFood(hamburger2, 150);
        Oven.reheatFood(hamburger3, 170);
        Oven.reheatFood(hamburger4, -200);


    }
}

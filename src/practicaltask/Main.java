package practicaltask;

public class Main {

    public static void main(String[] args) {

// TODO: Задание - не изменяя состав рецептов, параметры методов создания и разогрева гамбургеров.
//  Сделайте процесс работоспособным, используя в Main конструкции try catch finally
//  Доработайте исключение OvenException() в классе Hamburger
//  Постарайтесь выполнить практическое задание не прибегаю к координальному изменению классов:
//  Hamburger, HamburgerMaker, Oven, Food.
        //рецепты
        String[] recipe = {"булочка белая", "говядина", "огурчики", "кетчуп"};
        String[] recipe1 = {"булочка белая", "говядина", "огурчики"};
        String[] recipe2 = {"булочка белая", "говядина", "огурчики", "кетчуп", "лук"};
        String[] recipe3 = {null, "говядина", "огурчики", null};
        String[] recipe4 = {"булочка белая", "говядина", "огурчики", "кетчуп"};

        //создаем гамбургеры по рецептам
        Food hamburger = HamburgerMaker.make(recipe);
        Food hamburger1 = HamburgerMaker.make(recipe1);
        Food hamburger2 = HamburgerMaker.make(recipe2);
        Food hamburger3 = HamburgerMaker.make(recipe3);
        Food hamburger4 = HamburgerMaker.make(recipe4);


        //разогреваем
        Oven.reheatFood(hamburger, 80);
        Oven.reheatFood(hamburger1, 100);
        Oven.reheatFood(hamburger2, 150);
        Oven.reheatFood(hamburger3, 80);
        Oven.reheatFood(hamburger4, -200);


    }
}

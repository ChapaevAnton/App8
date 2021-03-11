package practicaltask;
// TODO: Класс создания гамбургеров
class HamburgerMaker {

    static Hamburger make(String[] recipe) {

        // TODO: обработайте исключение
        if (recipe.length > 4) throw new ArrayStoreException();
        Hamburger hamburger = new Hamburger(recipe[0], recipe[1], recipe[2], recipe[3]);
        System.out.println("Гамбургер создан...");
        System.out.println(hamburger);
        return hamburger;
    }

}

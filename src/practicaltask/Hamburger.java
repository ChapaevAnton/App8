package practicaltask;
// TODO: Это класс Гамбургер

class Hamburger extends Food {

    //ингредиенты
    private String bun; //булочка
    private String meat; //мясо
    private String greens;//зелень
    private String sauce;//соус


    Hamburger(String bun, String meat, String greens, String sauce) {
        // TODO: обработайте исключение
        if (bun == null || meat == null || greens == null || sauce == null) throw new NullPointerException();
        this.bun = bun;
        this.meat = meat;
        this.greens = greens;
        this.sauce = sauce;
        hot = false;
    }

    //процесс разгорева гамбургера
    @Override
    public void reheat(int timeSeconds) throws IllegalArgumentException, OvenException {
        this.hot = true;

        // TODO: обработайте исключение
        if (timeSeconds <= 0) throw new IllegalArgumentException();


        for (int i = 0; i < Math.abs(timeSeconds); i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            temperature++;
            if (temperature == 100)
                // TODO: Доработайте и сгенерируйте свое исключение если температур достигла критической отметки
                throw new OvenException();
            if (temperature > 0) hot = true;

        }
    }

    @Override
    public String toString() {
        return "Состав:{" +
                "булочка='" + bun + '\'' +
                ", мясо='" + meat + '\'' +
                ", зелень='" + greens + '\'' +
                ", соус='" + sauce + '\'' +
                '}';
    }
}

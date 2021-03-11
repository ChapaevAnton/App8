package practicaltask;
// TODO: Это класс Гамбургер

class Hamburger extends Food {

    private String bun;
    private String meat;
    private String greens;
    private String sauce;


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
    public void reheat(int timeSeconds) {
        this.hot = true;

        // TODO: обработайте исключение
        if (timeSeconds <= 0) throw new IllegalArgumentException();


        for (int i = 0; i < Math.abs(timeSeconds); i++) {

            try {
                Thread.sleep(100);

                temperature++;
                if (temperature == 100)
                    // TODO: Доработайте и сгенерируйте свое исключение если температур достигла критической отметки
                    throw new OvenException();
                if (temperature > 0) hot = true;
            } catch (InterruptedException | OvenException e) {
                e.printStackTrace();
            }
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

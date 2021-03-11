package practicaltask;

abstract class Food implements Heater {
    protected int temperature;
    protected boolean hot;

    protected int getTemperature() {
        return temperature;
    }

    protected boolean isHot() {
        return hot;
    }
}

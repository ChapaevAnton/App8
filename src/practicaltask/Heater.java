package practicaltask;

//TODO интерфейс - содержит метод разогрева еды,
// по которому плита(печка) знает как разогревать конкретную еду
public interface Heater {
    void reheat(int timeSeconds) throws OvenException;
}

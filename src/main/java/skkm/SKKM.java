package skkm;
import util.Vector2;

public class SKKM {
    BaseContainer bases;
    IDispositionStrategy strategy;
    void Dispose(Vector2 location, int amount)
    {
        strategy.ChoseVehicles(bases, location, amount);
    }
}

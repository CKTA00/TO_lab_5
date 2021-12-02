package skkm;

import util.Vector2;

import java.util.List;

public interface IDispositionStrategy {
    public List<ISKKMObserver> ChoseVehicles(BaseContainer bases, Vector2 location, int amount);
}

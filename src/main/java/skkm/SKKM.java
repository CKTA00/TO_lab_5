package skkm;
import event.EventAlarm;
import util.Vector2;

import java.util.LinkedList;
import java.util.List;

public class SKKM {
    BaseContainer bases;
    IDispositionStrategy strategy;

    List<ISKKMObserver> observersCollection;

    public SKKM(IDispositionStrategy strategy, BaseContainer bases)
    {
        observersCollection = new LinkedList<>();
        ChangeStrategy(strategy);
        this.bases = bases;
    }

    public void ChangeStrategy(IDispositionStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void AddObserver(ISKKMObserver observer)
    {
        observersCollection.add(observer);
    }

    public void RemoveObserver(ISKKMObserver observer)
    {
        observersCollection.remove(observer);
    }

    public void Notify(ISKKMObserver observer)
    {
        if(observersCollection.contains(observer))
        {
            observer.Send();
        }
    }

    public void NotifyAll()
    {
        for (var observer:
             observersCollection) {
            observer.Send();
        }
    }

    public void Alarm(EventAlarm eventAlarm)
    {

    }

    void Dispose(Vector2 location, int amount)
    {
        strategy.ChoseVehicles(this, location, amount);
    }
}

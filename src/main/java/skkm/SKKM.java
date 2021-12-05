package skkm;
import event.EventAlarm;
import ui.IGeneralUI;
import util.Vector2;

import java.util.LinkedList;
import java.util.List;

public class SKKM {
    BaseContainer bases;
    IDispositionStrategy strategy;
    IGeneralUI ui;

    List<ISKKMObserver> observersCollection;

    public SKKM(IDispositionStrategy strategy, BaseContainer bases, IGeneralUI ui)
    {
        observersCollection = new LinkedList<>();
        ChangeStrategy(strategy);
        this.bases = bases;
        this.ui = ui;
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
        ui.Println("Zgłoszenie zdarzenia:");
        ui.Print("\tTYP: "+eventAlarm.GetType());
        ui.Println("\tLOKALIZACJA: "+eventAlarm.GetLocation());
        Dispose(eventAlarm.GetLocation(),eventAlarm.GetRequiredVehicleAmount());
    }

    void Dispose(Vector2 location, int amount)
    {
        strategy.ChoseVehicles(this, location, amount);
    }

}

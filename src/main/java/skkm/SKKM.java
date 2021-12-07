package skkm;
import base.BaseContainer;
import event.EventAlarm;
import ui.IGeneralUI;

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

    public void Notify(ISKKMObserver observer, EventAlarm event)
    {
        if(observersCollection.contains(observer))
        {
            observer.Send(event);
        }
    }

    public void NotifyAll(EventAlarm event)
    {
        for (var observer:
             observersCollection) {
            observer.Send(event);
        }
    }

    public void Alarm(EventAlarm eventAlarm)
    {
        ui.Println("Zgłoszenie zdarzenia:");
        ui.Println("\tTYP: "+eventAlarm.GetType());
        ui.Println("\tLOKALIZACJA: "+eventAlarm.GetLocation());
        Dispose(eventAlarm);
    }

    void Dispose(EventAlarm event)
    {
        strategy.SendVehicles(this, event);
    }

    public void UpdateAll(long updateTime) {
        for (var observer:
                observersCollection) {
            observer.Update(updateTime);
        }
    }
}

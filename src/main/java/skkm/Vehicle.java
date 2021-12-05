package skkm;

import event.EventAlarm;
import vehicle_state.*;

public class Vehicle implements ISKKMObserver{

    GenericVehicleState state;
    public DisposedVehicleState disposed;
    public AvailableVehicleState available;
    public InActionVehicleState inAction;
    public ReturningVehicleState returning;

    String name;

    public Vehicle(String name)
    {
        this.name = name;

        disposed = new DisposedVehicleState();
        available = new AvailableVehicleState();
        inAction = new InActionVehicleState();
        returning = new ReturningVehicleState();
        ChangeState(available);
    }

    public void ChangeState(GenericVehicleState state)
    {
        this.state = state;
        state.EnterState();
    }

    public void Update(long time)
    {
        state.Update(this, time);
    }

    public boolean isAvailable()
    {
        return state.IsVehicleAvailable();
    }

    @Override
    public void Send(EventAlarm event) {
        if(state==disposed)
            System.out.println("(x) pojazd już jest wystawiony");
        else
        {
            disposed.SetDestination(event);
            ChangeState(disposed);
        }

    }

    public String GetName() {
        return name;
    }
}

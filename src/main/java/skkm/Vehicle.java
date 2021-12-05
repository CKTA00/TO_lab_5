package skkm;

import vehicle_state.AvailableVehicleState;
import vehicle_state.DisposedVehicleState;
import vehicle_state.GenericVehicleState;

public class Vehicle implements ISKKMObserver{

    GenericVehicleState state;
    public DisposedVehicleState disposed;
    public AvailableVehicleState available;

    public Vehicle()
    {
        disposed = new DisposedVehicleState();
        available = new AvailableVehicleState();
        ChangeState(available);
    }

    public void ChangeState(GenericVehicleState state)
    {
        this.state = state;
        state.EnterState();
    }

    public void Update()
    {
        state.Update();
    }

    public boolean isAvailable()
    {
        return state == available;
    }

    @Override
    public void Send() {

    }
}

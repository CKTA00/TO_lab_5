package vehicle_state;

import skkm.Vehicle;

public abstract class GenericVehicleState {
    public abstract void EnterState();
    public abstract void Update(Vehicle ctx, long time);
    public abstract boolean IsVehicleAvailable();
}

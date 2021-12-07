package vehicle.vehicle_state;

import vehicle.Vehicle;

public abstract class GenericVehicleState {
    public abstract void EnterState();
    public abstract void Update(Vehicle ctx, long time);
    public abstract boolean IsVehicleAvailable();
}

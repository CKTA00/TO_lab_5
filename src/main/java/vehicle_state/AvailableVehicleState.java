package vehicle_state;

import skkm.Vehicle;

public class AvailableVehicleState extends GenericVehicleState{


    public AvailableVehicleState() {

    }

    @Override
    public void EnterState() {

    }

    @Override
    public void Update(Vehicle ctx, long time) {

    }

    @Override
    public boolean IsVehicleAvailable() {
        return true;
    }
}

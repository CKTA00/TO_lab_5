package vehicle.vehicle_state;

import application.Application;
import vehicle.Vehicle;
import ui.IGeneralUI;

import java.util.Random;

public class ReturningVehicleState extends GenericVehicleState{
    static final long minTravelTime = 0;
    static final long maxTravelTime = 3000;

    long timeSincePoint;
    long travelTime;

    @Override
    public void EnterState() {
        Random random = new Random();
        travelTime = random.nextInt() % (maxTravelTime-minTravelTime) + minTravelTime;
        timeSincePoint = 0;
    }

    @Override
    public void Update(Vehicle ctx, long time) {
        timeSincePoint += time;
        if(timeSincePoint>travelTime)
        {
            IGeneralUI ui = Application.GetCurrentUI();
            ui.Println("[i] " + ctx.GetName() + " powrócił do bazy.");
            ctx.ChangeState(ctx.available);
        }
    }

    @Override
    public boolean IsVehicleAvailable() {
        return false;
    }
}

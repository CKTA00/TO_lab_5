package vehicle.vehicle_state;

import application.Application;
import vehicle.Vehicle;
import ui.IGeneralUI;

import java.util.Random;

public class InActionVehicleState extends GenericVehicleState {

    static final long minActionTime = 5000;
    static final long maxActionTime = 25000;

    long timeSinceBeginning;
    long actionTime;

    @Override
    public void EnterState() {
        Random random = new Random();
        actionTime = random.nextInt() % (maxActionTime-minActionTime) + minActionTime;
        timeSinceBeginning = 0;
    }

    @Override
    public void Update(Vehicle ctx, long time) {
        timeSinceBeginning += time;
        if(timeSinceBeginning>actionTime)
        {
            IGeneralUI ui = Application.GetCurrentUI();
            ui.Println("[i] " + ctx.GetName() + " zakończył akcję.");
            ctx.ChangeState(ctx.returning);
        }
    }

    @Override
    public boolean IsVehicleAvailable() {
        return false;
    }
}

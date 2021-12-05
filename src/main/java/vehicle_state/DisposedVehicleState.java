package vehicle_state;

import event.EventAlarm;
import skkm.Vehicle;

import java.util.Random;

public class DisposedVehicleState extends GenericVehicleState{

    static final long minTravelTime = 0;
    static final long maxTravelTime = 3000;

    long timeSinceDeploy;
    long travelTime;

    EventAlarm destinationEvent;

    public DisposedVehicleState DisposedVehicleState()
    {
        return this;
    }

    public void SetDestination(EventAlarm event)
    {
        destinationEvent = event;
    }

    @Override
    public void EnterState() {
        Random random = new Random();
        travelTime = random.nextInt() % (maxTravelTime-minTravelTime) + minTravelTime;
        timeSinceDeploy = 0;
    }

    @Override
    public void Update(Vehicle ctx, long time) {
        timeSinceDeploy += time;
        if(timeSinceDeploy > travelTime)
        {
            if(destinationEvent.IsFalseAlarm())
            {
                ctx.ChangeState(ctx.returning);
                System.out.println("[i] " + ctx.GetName() + " rozpoznał fałszywy alarm! Powrót pojazdu..."); // TODO: ui system
            }
            else{
                ctx.ChangeState(ctx.inAction);
                System.out.println("[i] " + ctx.GetName() + " rozpoczął akcje."); // TODO: ui system
            }
        }
    }

    @Override
    public boolean IsVehicleAvailable() {
        return false;
    }
}

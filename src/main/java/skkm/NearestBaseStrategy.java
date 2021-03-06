package skkm;

import base.Base;
import event.EventAlarm;
import my_util.Iterator;
import my_util.Vector2;
import vehicle.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class NearestBaseStrategy implements IDispositionStrategy {
    @Override
    public void SendVehicles(SKKM ctx, EventAlarm event) {

        Vector2 location = event.GetLocation();
        int amount = event.GetRequiredVehicleAmount();

        List<Base> excluded = new LinkedList<>();

        while(amount>0)
        {
            Iterator it = ctx.bases.iterator();

            Base currentBase;
            Base nearestBase = null;
            double minDistance = Double.MAX_VALUE;
            double currentDistance;
            while(it.hasNext())
            {
                currentBase = (Base) it.next();
                if(excluded.contains(currentBase))
                {
                    continue;
                }
                currentDistance = Vector2.Distance(currentBase.location,location);
                if(minDistance>currentDistance)
                {
                    minDistance = currentDistance;
                    nearestBase = currentBase;
                }
            }

            if(nearestBase == null)
            {
                ctx.ui.Println("/!\\ Brak wystarczającej liczby pojazdów!");
                break;
            }

            excluded.add(nearestBase);
            ctx.ui.Print("Z bazy " + nearestBase.name + " wyruszyły ");
            int newAmount = TrySendingAndGetRest(ctx, nearestBase, event, amount);
            ctx.ui.Println( (amount-newAmount) + " pojazdy.");
            amount = newAmount;
        }
    }

    int TrySendingAndGetRest(SKKM ctx, Base nearestBase, EventAlarm event, int amount)
    {
        Iterator it = nearestBase.iterator();
        while(it.hasNext() && amount>0)
        {
            Vehicle veh = (Vehicle) it.next();
            if(veh.IsAvailable())
            {
                ctx.Notify(veh,event);
                amount--;
            }
        }
        return amount;
    }
}

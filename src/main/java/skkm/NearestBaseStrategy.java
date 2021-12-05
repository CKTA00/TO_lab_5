package skkm;

import util.Iterator;
import util.Vector2;

import java.util.LinkedList;
import java.util.List;

public class NearestBaseStrategy implements IDispositionStrategy {
    @Override
    public void ChoseVehicles(SKKM ctx, Vector2 location, int amount) {

        List<Base> excluded = new LinkedList<Base>();

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
            int newAmount = SendVehiclesAndGetRest(ctx,nearestBase, amount);
            ctx.ui.Println( (amount-newAmount) + " pojazdy.");
            amount = newAmount;
        }
    }

    int SendVehiclesAndGetRest(SKKM ctx, Base nearestBase, int amount)
    {
        Iterator it = nearestBase.iterator();
        while(it.hasNext() && amount>0)
        {
            Vehicle veh = (Vehicle) it.next();
            if(veh.isAvailable())
            {
                ctx.Notify(veh);
                amount--;
            }
        }
        return amount;
    }
}

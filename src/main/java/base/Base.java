package base;

import skkm.SKKM;
import vehicle.Vehicle;
import vehicle.VehicleIterator;
import my_util.Aggregator;
import my_util.Iterator;
import my_util.Vector2;

public class Base extends Aggregator {
    public String name;
    public Vector2 location;
    Vehicle[] units;

    public Base(String name, Vector2 location) {
        this.name = name;
        this.location = location;
        this.units = new Vehicle[5];

        for (int i =0; i<units.length; i++) {
            units[i] = new Vehicle("Pojazd " + i + " z bazy " + name);
        }
    }

    public void SubscribeAllVehiclesTo(SKKM center)
    {
        for (var veh:
             units) {
            center.AddObserver(veh);
        }
    }

    public void UpdateAllVehicles(long time){
        for (var veh:
                units) {
            veh.Update(time);
        }
    }

    public Iterator iterator() {
        return new VehicleIterator(units);
    }
}

package skkm;

import util.Aggregator;
import util.Iterator;
import util.Vector2;

public class Base extends Aggregator {
    public String name;
    public Vector2 location;
    Vehicle[] units;

    public Base(String name, Vector2 location) {
        this.name = name;
        this.location = location;
        this.units =  new Vehicle[3];
    }

    public Iterator iterator() {
        return new VehicleIterator(units);
    }
}

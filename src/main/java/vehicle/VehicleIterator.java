package vehicle;

import my_util.Iterator;

public class VehicleIterator extends Iterator {

    Vehicle[] units;
    int index;

    public VehicleIterator(Vehicle[] units)
    {
        this.units = units;
        index = -1;
    }

    @Override
    public boolean hasNext() {
        return (index<units.length-1);
    }

    @Override
    public Object next() {
        index++;
        return units[index];
    }
}

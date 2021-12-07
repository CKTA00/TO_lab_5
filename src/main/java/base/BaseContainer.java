package base;

import skkm.SKKM;
import my_util.Aggregator;
import my_util.Iterator;

import java.util.LinkedList;
import java.util.List;

public class BaseContainer extends Aggregator {
    public List<Base> list;

    public BaseContainer()
    {
        list = new LinkedList<Base>();
    }

    public void AddBase(Base base)
    {
        list.add(base);
    }

    public void SubscribeAllVehicles(SKKM center)
    {
        for (var base:
             list) {
            base.SubscribeAllVehiclesTo(center);
        }
    }

    @Override
    public Iterator iterator() {
        return new BaseIterator(list);
    }
}

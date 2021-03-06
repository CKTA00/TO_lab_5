package base;

import my_util.Iterator;

import java.util.List;

public class BaseIterator extends Iterator {

    private java.util.Iterator<Base> subIterator;
    public BaseIterator(List<Base> list) //reference
    {
        subIterator = list.iterator();
    }

    @Override
    public boolean hasNext() {
        return subIterator.hasNext();
    }

    @Override
    public Object next() {
        return subIterator.next();
    }
}

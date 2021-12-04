package skkm;

import util.Iterator;

import java.util.List;

public class BaseIterator extends Iterator {

    private List<Base> list;
    public BaseIterator(List<Base> list) //reference
    {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}

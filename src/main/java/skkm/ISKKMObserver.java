package skkm;

import event.EventAlarm;

public interface ISKKMObserver {
    public void Send(EventAlarm event);
}

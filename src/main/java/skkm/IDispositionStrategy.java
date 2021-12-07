package skkm;

import event.EventAlarm;

public interface IDispositionStrategy {
    public void SendVehicles(SKKM ctx, EventAlarm event);
}

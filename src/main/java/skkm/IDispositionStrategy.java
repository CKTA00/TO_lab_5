package skkm;

import event.EventAlarm;

public interface IDispositionStrategy {
    public void ChoseVehicles(SKKM ctx, EventAlarm event);
}

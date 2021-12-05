package skkm;

import event.EventAlarm;
import util.Vector2;

import java.util.List;

public interface IDispositionStrategy {
    public void ChoseVehicles(SKKM ctx, EventAlarm event);
}

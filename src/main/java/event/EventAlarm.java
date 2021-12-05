package event;

import util.Vector2;

import java.util.Random;

public class EventAlarm {

    public static final float defaultFalseAlarmChance = 0.05f;
    boolean isFalseAlarm;
    Vector2 location;

    public EventAlarm(Vector2 location, boolean isFalseAlarm)
    {
        this.location = location;
        this.isFalseAlarm = isFalseAlarm;
    }

    public boolean IsFalseAlarm()
    {
        return isFalseAlarm;
    }

    public Vector2 GetLocation()
    {
        return new Vector2(location.x,location.y);
    }

    public String GetType()
    {
        return "undefined event";
    }

    public int GetRequiredVehicleAmount()
    {
        return 0;
    }
}

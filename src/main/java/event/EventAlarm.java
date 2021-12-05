package event;

import java.util.Random;

public class EventAlarm {

    public static final float defaultFalseAlarmChance = 0.05f;
    boolean isFalseAlarm;

    public EventAlarm()
    {
        this(defaultFalseAlarmChance);
    }

    public EventAlarm(float falseAlarmChance)
    {
        Random random = new Random();
        if(random.nextFloat() < falseAlarmChance)
        {
            isFalseAlarm = true;
        }
    }

    public boolean IsFalseAlarm()
    {
        return isFalseAlarm;
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

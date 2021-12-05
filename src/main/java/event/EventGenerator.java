package event;

import util.Vector2;

import java.util.Random;

public class EventGenerator {

    static Random gen;
    Vector2 pointFrom;
    Vector2 pointTo;
    float fireChance;
    float falseAlarmChance;

    public EventGenerator(Vector2 from, Vector2 to, float fireChance, float falseAlarmChance)
    {
        pointFrom = from;
        pointTo = to;
        if(gen==null)
            gen = new Random();
        this.fireChance = fireChance;
        this.falseAlarmChance = falseAlarmChance;
    }

    public EventAlarm Generate()
    {
        boolean isFalseAlarm = false;
        if(gen.nextFloat() < falseAlarmChance)
        {
            isFalseAlarm = true;
        }

        Vector2 location = new Vector2(
                pointFrom.x + gen.nextDouble()*(pointTo.x-pointFrom.x),
                pointFrom.y + gen.nextDouble()*(pointTo.y-pointFrom.y)
        );

        if(gen.nextFloat()<fireChance)
        {
            return new FireAlarm(location,isFalseAlarm);
        }
        else
        {
            return new LocalThreatAlarm(location,isFalseAlarm);
        }

    }
}

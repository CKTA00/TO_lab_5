package event;

import my_util.Vector2;

import java.util.Random;

public class EventGenerator implements IEventGenerator {

    static Random rand;
    Vector2 pointFrom;
    Vector2 pointTo;
    float fireChance;
    float falseAlarmChance;

    long generatorTimer;
    final long maxNewAlarmTime; //miliSeconds
    final long minNewAlarmTime; //miliSeconds


    public EventGenerator(Vector2 from, Vector2 to, float fireChance, float falseAlarmChance, long minNewAlarmTime, long maxNewAlarmTime)
    {
        pointFrom = from;
        pointTo = to;
        if(rand == null)
            rand = new Random();
        this.fireChance = fireChance;
        this.falseAlarmChance = falseAlarmChance;
        this.minNewAlarmTime = minNewAlarmTime;
        this.maxNewAlarmTime = maxNewAlarmTime;
    }

    public EventAlarm Generate()
    {
        boolean isFalseAlarm = false;
        generatorTimer = rand.nextInt() % (maxNewAlarmTime - minNewAlarmTime) + minNewAlarmTime;
        if(rand.nextFloat() < falseAlarmChance)
        {
            isFalseAlarm = true;
        }

        Vector2 location = new Vector2(
                pointFrom.x + rand.nextDouble()*(pointTo.x-pointFrom.x),
                pointFrom.y + rand.nextDouble()*(pointTo.y-pointFrom.y)
        );

        if(rand.nextFloat()<fireChance)
        {
            return new FireAlarm(location,isFalseAlarm);
        }
        else
        {
            return new LocalThreatAlarm(location,isFalseAlarm);
        }
    }

    public boolean UpdateAndCheckForNewAlarm(long updateTime)
    {
        if(generatorTimer <=0)
            return true;
        else
        {
            generatorTimer -= updateTime;
            return false;
        }
    }
}

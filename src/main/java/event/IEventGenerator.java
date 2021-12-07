package event;

public interface IEventGenerator {
    public EventAlarm Generate();
    public boolean UpdateAndCheckForNewAlarm(long updateTime);
}

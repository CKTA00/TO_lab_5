package event;

import my_util.Vector2;

public class LocalThreatAlarm extends EventAlarm{
    public LocalThreatAlarm(Vector2 location, boolean isFalseAlarm) {
        super(location, isFalseAlarm);
    }

    @Override
    public String GetType() {
        return "MZ";
    }

    @Override
    public int GetRequiredVehicleAmount() {
        return 2;
    }
}

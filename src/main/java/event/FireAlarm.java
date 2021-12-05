package event;

import util.Vector2;

public class FireAlarm extends EventAlarm{

    public FireAlarm(Vector2 location, boolean isFalseAlarm) {
        super(location, isFalseAlarm);
    }

    @Override
    public String GetType() {
        return "PZ";
    }

    @Override
    public int GetRequiredVehicleAmount() {
        return 3;
    }
}

package event;

public class FireAlarm extends EventAlarm{

    @Override
    public String GetType() {
        return "PZ";
    }

    @Override
    public int GetRequiredVehicleAmount() {
        return 3;
    }
}

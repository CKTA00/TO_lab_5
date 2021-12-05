package event;

public class LocalThreatAlarm extends EventAlarm{
    @Override
    public String GetType() {
        return "MZ";
    }

    @Override
    public int GetRequiredVehicleAmount() {
        return 2;
    }
}

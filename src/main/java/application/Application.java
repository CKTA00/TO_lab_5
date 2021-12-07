package application;

import base.Base;
import base.BaseContainer;
import event.EventGenerator;
import event.IEventGenerator;
import skkm.IDispositionStrategy;
import skkm.NearestBaseStrategy;
import skkm.SKKM;
import ui.ConsoleUI;
import ui.IGeneralUI;
import my_util.Vector2;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public final class Application {
    // Program elements:
    static IGeneralUI ui;
    static BaseContainer bases;
    static IDispositionStrategy strategy;
    static SKKM center;
    static IEventGenerator generator;

    // Schedule related:
    static final long updateTime = 50; //miliSeconds

    public static void Run()
    {

        ui = new ConsoleUI();
        ui.Println("Preparing...");
        bases = CreateDefaultBases();
        strategy = new NearestBaseStrategy();
        center = new SKKM(strategy, bases, ui);
        bases.SubscribeAllVehicles(center); // Maybe move to SKKM constructor?
        generator = (IEventGenerator) new EventGenerator(
                new Vector2(49.95855025648944,19.688292482742394),
                new Vector2(50.154564013341734, 20.02470275868903),
                0.3f,
                0.05f,
                100,
                5000
        );


        Timer timer = new Timer();
        Random rand = new Random();
        TimerTask update = new TimerTask() {
            @Override
            public void run() {
                Update(rand);
            }
        };
        ui.Println("READY");
        timer.schedule(update, 0, updateTime);
    }

    private static BaseContainer CreateDefaultBases()
    {
        BaseContainer bases = new BaseContainer();
        bases.AddBase(new Base("JRG 1",new Vector2(50.06723246707029, 19.941007344353647)));
        bases.AddBase(new Base("JRG 2",new Vector2(50.040780194910774, 19.936887471270342)));
        bases.AddBase(new Base("JRG 3",new Vector2(50.08089376130773, 19.88538905772902)));
        bases.AddBase(new Base("JRG 4",new Vector2(50.0463859509817, 20.008813688854186)));
        bases.AddBase(new Base("JRG 5",new Vector2(50.09706740915194, 19.922982999618668)));
        bases.AddBase(new Base("JRG 6",new Vector2(50.022128056338424, 20.01636678950691)));
        bases.AddBase(new Base("JRG 7",new Vector2(50.10059108325477, 19.9779146407294)));
        bases.AddBase(new Base("Aspiranci",new Vector2(50.08517309563034, 20.035592863895666)));
        bases.AddBase(new Base("Lotnisko",new Vector2(50.08076704512346, 19.78634054235572)));
        bases.AddBase(new Base("Skawina",new Vector2(49.97710824718122, 19.80282003468894)));
        return bases;
    }

    private static void Update(Random rand)
    {
        if(generator.UpdateAndCheckForNewAlarm(updateTime))
            center.Alarm(generator.Generate());
        //bases.UpdateAllVehicles(updateTime);
        center.UpdateAll(updateTime);
    }

    public static IGeneralUI GetCurrentUI()
    {
        return ui;
    }
}

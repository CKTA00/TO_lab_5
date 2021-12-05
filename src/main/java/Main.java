import skkm.Base;
import skkm.BaseContainer;
import skkm.NearestBaseStrategy;
import skkm.SKKM;
import util.Vector2;

import java.util.LinkedList;

public class Main {
    public static void main(String args[])
    {
        System.out.println("Preparing...");
        BaseContainer bases = CreateDefaultBases();
        NearestBaseStrategy strategy = new NearestBaseStrategy();
        SKKM center = new SKKM(strategy,bases);
        bases.SubscribeAllVehicles(center); // Maybe move to SKKM constructor?

        System.out.println("READY");
        //System.out.println("Event generator is running");
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
}

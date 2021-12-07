package ui;

public class ConsoleUI implements IGeneralUI{



//    static IGeneralUI instance;
//    private ConsoleUI()
//    {
//
//    }
//
//    public static IGeneralUI GetInstance()
//    {
//        if(instance==null)
//            instance = new ConsoleUI();
//        return instance;
//    }

    public void Println(String message)
    {
        System.out.println(message);
    }
    public void Print(String message)
    {
        System.out.print(message);
    }
}

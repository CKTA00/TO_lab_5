package ui;

public class ConsoleUI implements IGeneralUI{

    public void Println(String message)
    {
        System.out.println(message);
    }
    public void Print(String message)
    {
        System.out.print(message);
    }
}

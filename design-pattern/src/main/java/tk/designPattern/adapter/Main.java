package tk.designPattern.adapter;

public class Main {

    public static void main(String[] args) {
        Print print = new PrintBanner("hello");
        print.printString();
    }
}

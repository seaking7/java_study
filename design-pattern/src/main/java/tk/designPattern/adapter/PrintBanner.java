package tk.designPattern.adapter;

public class PrintBanner implements Print{

    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeek() {
        banner.showWithParen();
    }

    @Override
    public void printString() {
        banner.showWithAster();
    }
}

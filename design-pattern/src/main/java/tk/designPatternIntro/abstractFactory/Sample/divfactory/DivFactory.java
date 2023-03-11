package tk.designPatternIntro.abstractFactory.Sample.divfactory;

import tk.designPatternIntro.abstractFactory.Sample.factory.Factory;
import tk.designPatternIntro.abstractFactory.Sample.factory.Link;
import tk.designPatternIntro.abstractFactory.Sample.factory.Page;
import tk.designPatternIntro.abstractFactory.Sample.factory.Tray;

public class DivFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new DivLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new DivTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new DivPage(title, author);
    }
}

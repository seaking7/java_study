package tk.designPatternIntro.abstractFactory.Sample.listfactory;

import tk.designPatternIntro.abstractFactory.Sample.factory.Factory;
import tk.designPatternIntro.abstractFactory.Sample.factory.Link;
import tk.designPatternIntro.abstractFactory.Sample.factory.Page;
import tk.designPatternIntro.abstractFactory.Sample.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}

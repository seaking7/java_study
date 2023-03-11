package tk.designPatternIntro.visitor.Sample;

public interface Element {
    public abstract void accept(Visitor v);
}

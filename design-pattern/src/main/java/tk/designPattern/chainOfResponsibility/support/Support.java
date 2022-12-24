package tk.designPattern.chainOfResponsibility.support;

import tk.designPattern.chainOfResponsibility.Trouble;

public abstract class Support {
    private String name;
    private Support next;

    public Support(String name){
        this.name = name;
    }

    public Support setNext(Support next){
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble){
        if(resolve(trouble)){
            done(trouble);
        }
        else if(next != null){
            next.support(trouble);
        }
        else{
            fail(trouble);
        }
    }

    protected void done(Trouble trouble) {  // 해결
        System.out.println(trouble + " is resolved by " + this + ".");
    }
    protected void fail(Trouble trouble) {  // 미해결
        System.out.println(trouble + " cannot be resolved.");
    }


    protected abstract boolean resolve(Trouble trouble);

    @Override
    public String toString() {
        return "Support{" +
                "name='" + name + '\'' +
                '}';
    }
}

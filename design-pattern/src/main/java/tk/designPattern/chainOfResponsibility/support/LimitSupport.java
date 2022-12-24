package tk.designPattern.chainOfResponsibility.support;

import tk.designPattern.chainOfResponsibility.Trouble;

public class LimitSupport extends Support {
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if( trouble.getNumber() < limit){
            return true;
        }
        return false;
    }
}

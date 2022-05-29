package tk.designPattern.chainOfResponsibility.support;

import tk.designPattern.chainOfResponsibility.Trouble;

public class OddSupport extends Support {
    public OddSupport(String name) {                // 생성자
        super(name);
    }
    protected boolean resolve(Trouble trouble) {    // 해결용 메소드
        if (trouble.getNumber() % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

}

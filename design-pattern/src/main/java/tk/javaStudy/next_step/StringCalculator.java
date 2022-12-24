package tk.javaStudy.next_step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    int add(String text){
        if(isBlank(text))
            return 0;

        return sum(split(text));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            return m.group(2).split(m.group(1));
        }
        return text.split(",|:");
    }

    private int sum( String[] tokens) {
        int returnValue = 0;
        for (String token : tokens) {
            returnValue += toPositive(token);
        }
        return returnValue;
    }

    private int toPositive(String token) {
        int i = Integer.parseInt(token);
        if(i < 0) throw new RuntimeException("음수는 입력불가");
        return i;
    }

}

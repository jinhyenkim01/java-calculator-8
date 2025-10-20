package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String separators = "[:,]";

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        if(input.startsWith("//")){
            String newSeparator = input.substring(2);
            if(newSeparator.length() != 1){
                System.out.println("Error");
            }else{
                separators = "[:,]" + "|" + Pattern.quote(newSeparator);
                input = Console.readLine();
            }
        }
        //System.out.println(input);
        String[] split = input.split(separators);

        float result = 0.0f;

        for (String elem : split) {
            try {
                float temp = Float.parseFloat(elem);
                result = result + temp;
            } catch (NumberFormatException e) {
                System.out.println("Error");
            }
        }

        int intResult = (int) result;
        if(result == intResult){
            System.out.println("결과 : " + intResult);
        }else{
            System.out.println("결과 : " + result);
        }
    }
}

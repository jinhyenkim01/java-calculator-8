package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        HashMap<Character, Boolean> separatorChar = new HashMap<Character, Boolean>();
        separatorChar.put(',', true);
        separatorChar.put(':', true);

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        if(input.startsWith("//")){
            String newSeparator = input.substring(2);
            if(newSeparator.length() != 1){
                System.out.println("Error");
            }else{
                separatorChar.put(newSeparator.charAt(0), true);
                input = Console.readLine();
            }
        }
        System.out.println(input);
    }
}

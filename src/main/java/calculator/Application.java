package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 쉼표(,)와 콜론(:)을 구분자로 지정
        String separators = "[:,]";

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.startsWith("//")) {
            // 문자열 앞부분의 "//"을 제거한 후, "\n" 이전에 오는 문자를 구분자로 지정
            String truncatedStr = input.substring(2);
            String[] newSeparator = truncatedStr.split("\\\\n");
            if (newSeparator[0].length() != 1) {
                throw new IllegalArgumentException("// 로 시작하는 문자열은 // 이후 정확히 1개의 문자가 와야 합니다.");
            } else if (Character.isDigit(newSeparator[0].charAt(0))) {
                throw new IllegalArgumentException("0~9의 숫자는 구분자로 사용될 수 없습니다.");
            } else {
                separators = "[:,]" + "|" + Pattern.quote(newSeparator[0]);
                input = newSeparator[1];
            }
        }

        String[] split = input.split(separators);

        float result = 0.0f;

        for (String elem : split) {
            try {
                float temp = Float.parseFloat(elem);
                if (temp >= 0.0f) {
                    result = result + temp;
                } else {
                    throw new IllegalArgumentException("구분자 사이의 문자는 음수일 수 없습니다.");
                }

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자 사이의 문자는 양수로 이루어져야 합니다.");
            }
        }

        int intResult = (int) result;
        if (result == intResult) {
            System.out.println("결과 : " + intResult);
        } else {
            System.out.println("결과 : " + result);
        }
    }
}

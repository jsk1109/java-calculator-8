package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String input = Console.readLine();
        String[] list;
        if (input == null || input.equals("")) {
            System.out.println("결과 : 0");
            return;
        }
        if (input.startsWith("//")) {
            String pInput = input.replace("\\n","\n");
            String[] parts = pInput.split("\n", 2);
            if (parts.length < 2) {
                throw new IllegalArgumentException("커스텀 구분자 형식 오류 (\\n이 누락되었습니다.)");
            }
            String header = parts[0];
            String customDelimiter = header.substring(2);
            if (customDelimiter.equals("")) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
            }
            String numberString = parts[1];
            list = numberString.split(Pattern.quote(customDelimiter));
        } else {
            list = input.split(",|:");
        }
        
        int sum = 0;
        for (int i = 0; i < list.length; i++) {

            if (list[i].equals("")) {
                sum = sum + 0;
            } else {
                try {
                    int number = Integer.parseInt(list[i]);

                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }
                    sum = sum + number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
                }
            }
        }
        System.out.println("결과 : " + sum);
    }
}

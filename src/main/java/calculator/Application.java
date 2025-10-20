package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String input = Console.readLine();
        String[] list;

       if (input == null || input.equals("")){
           System.out.println("결과 : 0");
           return;
       }

        if(input.startsWith("//")){
            String[] parts = input.split("\n",2);
            String starts = parts[0];
            String custom = starts.substring(2);
            String numberString = parts[1];
            list = numberString.split(custom);
        }else{
            list = input.split(",|:");
        }

        int sum = 0;
        for(int i = 0; i < list.length; i++) {
            if(list[i].equals("")) {
                sum = sum + 0;
            }else{
                try {
                    int number = Integer.parseInt(list[i]);
                    if (number < 0) {
                        throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
                    }
                    sum = sum + number;
                }catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
                }
            }
        }
        System.out.println("결과 : " + sum);

    }
}

package programmers;

import java.util.Arrays;

public class No425777 {
    public static void main(String[] args) {
        String[] phone_book = {"12","131","134","1456","567","88","889"};
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
                if(phone_book[j].length() <= phone_book[i].length()){
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(phone_book));


    }
}

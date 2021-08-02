package programmers;

public class No82612 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        long answer = money;

        for(int i = 1; i <= count; i++){
            answer -= i*price;
        }
        System.out.println(answer < 0 ? - answer : 0);
    }
}

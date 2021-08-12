package programmers;

public class No67256 {
    public static void main(String[] args) {
        String answer = "";
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        int lHand,rHand;
        lHand = rHand = -1;
        for(int i = 0; i < numbers.length; i++){
            int now = numbers[i];

            if(now == 1 || now == 4 || now == 7){
                answer += "L";
                lHand = now;
            }else if (now == 3 || now == 6 || now == 9){
                answer +="R";
                rHand = now;
            }else{
                int lDis,rDis;
                lDis = -1;
                rDis = -1;
                // now는 2 5 8 0
                // 왼손이 있을 수 있는 위치  1 2 4 5 7 8 0 -1
                // 오른손이 있을 수 있는 위치 2 3 5 6 8 9 0 -1
                int nowX = 0;

                if(now != 0){
                    nowX = (now-1)/3;
                }else{
                    nowX = 3;
                }

                int lX = 0;
                if(lHand > 0){
                    lX = (lHand-1)/3;
                }else{
                    lX = 3;
                }
                int rX = 0;
                if(rHand > 0){
                    rX = (rHand-1)/3;
                }else{
                    rX = 3;
                }

                int lY = 0;
                if(lHand > 0){
                    lY = lHand - (lX*3)-1;
                }else if (lHand == -1){
                    lY = 0;
                }else{
                    lY = 1;
                }
                int rY = 0;
                if(rHand > 0){
                    rY = rHand - (rX*3)-1;
                }else if(rHand == -1){
                    rY = 2;
                }
                else{
                    rY = 1;
                }

                lDis = (nowX-lX < 0 ? lX-nowX : nowX-lX) + (1-lY < 0 ? lY-1 : 1-lY);
                rDis = (nowX-rX < 0 ? rX-nowX : nowX-rX) + (1-rY < 0 ? rY-1 : 1-rY);

                if(rDis == lDis){
                    if(hand.equals("right")){
                        answer += "R";
                        rHand = now;
                    }else{
                        answer += "L";
                        lHand = now;
                    }
                }else{
                    if(rDis > lDis){
                        answer += "L";
                        lHand = now;
                    }else{
                        answer += "R";
                        rHand = now;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

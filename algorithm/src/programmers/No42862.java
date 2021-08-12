package programmers;

public class No42862 {
    public static void main(String[] args) {
        int answer = 0;
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        int[] cache = new int[n+1];
        for(int i = 0; i < lost.length; i++){
            cache[lost[i]] -= 1;
        }
        for(int j = 0; j < reserve.length; j++){
            cache[reserve[j]] += 1;
        }

        for(int i = 1; i <= n ;i++){
            if(cache[i] == -1){ // 도난 당했을 때
                if(i == 1){ // 처음
                    if(cache[i+1] == 1){
                        cache[i]++;
                        cache[i+1]--;
                    }
                }else if(i == n){ // 끝
                    if(cache[i-1] == 1){
                        cache[i]++;
                        cache[i-1]--;
                    }
                }else{ // 그 외
                    if(cache[i-1] == 1 && cache[i+1] == 1){ // 양쪽 다 여분의 체육복 있을 때
                        if(i-2 <= 0){
                            cache[i-1]--;
                            cache[i]++;
                            continue;
                        }
                        if(i+2 > n ){
                            cache[i+1]--;
                            cache[i]++;
                            continue;
                        }
                        if(0 < i-2 && cache[i-2] != -1){
                            cache[i-1]--;
                            cache[i]++;
                            continue;
                        }
                        if(i+2 <= n && cache[i-2] != -1){
                            cache[i+1]--;
                            cache[i]++;
                            continue;
                        }
                    }else if(cache[i-1] == 1){ // 앞 친구만 여분의 체육복
                        cache[i-1]--;
                        cache[i]++;
                    }else if(cache[i+1] == 1){ // 뒤 친구만 여분의 체육복
                        cache[i+1]--;
                        cache[i]++;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(cache[i] == 0 || cache[i] == 1){
                answer++;
            }
        }
        System.out.println(answer);
    }
}

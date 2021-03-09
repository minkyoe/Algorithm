package 스택_큐;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int ansIdx = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int tmp = 0;
            if ((100 - progresses[i]) % speeds[i] != 0) 
                tmp = (100 - progresses[i]) / speeds[i] + 1;
            else
                tmp = (100 - progresses[i]) / speeds[i];
            q.offer(tmp);
        }
        
        while (!q.isEmpty()) {
            int top = q.poll();
            int cnt = 1;
            while (true) {
                if (q.isEmpty()) {
                    answer[ansIdx++] = cnt;
                    break;
                }
                    
                int next = q.peek();
                if (top >= next) {
                    cnt++;
                    q.poll();
                }
                else {
                    answer[ansIdx++] = cnt;
                    break;
                }
            }
        } // end of while
        
        int[] realAns = new int[ansIdx];
        for (int i = 0; i < ansIdx; i++) {
            realAns[i] = answer[i];
        }
        return realAns;
    }
}

package 구현;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[10001];    
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                int sum = numbers[i] + numbers[j];
                if (list.contains(sum)) continue;
                list.add(sum);
            }
        }
        
        Collections.sort(list);
        
        int[] realAnswer = new int[list.size()];
        int idx = 0;

        for (int i = 0; i < list.size(); i++) {
            realAnswer[idx++] = list.get(i);
        }
        return realAnswer;
    }
}

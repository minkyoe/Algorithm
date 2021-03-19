package 구현;
import java.util.*;

public class 같은숫자는싫어 {
	public class Solution {
	    public int[] solution(int []arr) {        
	        int[] answer = new int[1000001];
	        int idx = 0;
	        answer[idx++] = arr[0];
	        for (int i = 1; i < arr.length; i++) {
	            if (answer[idx-1] == arr[i]) continue;
	            answer[idx++] = arr[i];
	        }
	        
	        int[] realAnswer = new int[idx];
	        for (int i = 0; i < idx; i++) {
	            realAnswer[i] = answer[i];
	        }

	        return realAnswer;
	    }
	}
}

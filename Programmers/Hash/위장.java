package Hash;

import java.util.*;

public class 위장 {

	class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 1;
	        
	        Map<String, Integer> hm = new HashMap<String, Integer>();
	        for (int i = 0; i < clothes.length; i++) {
	            String kind = clothes[i][1];

	            if (hm.containsKey(kind)) {
	                hm.put(kind, hm.get(kind) + 1);
	            } else {
	                hm.put(kind, 1);
	            }
	        }
	        
	        for (Map.Entry<String,Integer> entry : hm.entrySet()) {
	           answer *= (entry.getValue() + 1);
	        }
	        
	        return answer-1;
	    }
	}
}

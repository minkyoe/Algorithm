package 구현;

public class 다음큰숫자 {
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        
	        String two = Integer.toBinaryString(n); // 이진수
	        int cnt = getOneCount(two);
	        int num = n;
	        
	        while (true) {
	            ++num;
	            String tmp = Integer.toBinaryString(num);
	            if (getOneCount(tmp) == cnt) break;
	        }
	        
	        answer = num;
	        return answer;
	    } // end of solution
	    
	    int getOneCount(String s) {
	        int cnt = 0;
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '1')
	                ++cnt;
	        }
	        return cnt;
	    }
	} // end of class
}

package KAKAO;

import java.util.Stack;

public class Solution_2020_괄호변환 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("()))((()"));
	}
	
	
	static class Solution {
	    public String solution(String p) {
	        String answer = "";
	        if ("".equals(p)) return ""; // 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
	        answer = seperate(p);
	        return answer;
	    }
	   
		private String seperate(String str) {
			int left = 0; // "(" 개수
			int right = 0; // ")" 개수
			
			for (int i = 0; i < str.length(); i++) {
				if ('(' == str.charAt(i)) {
					left++;
				}
				else {
					right++;
				}
				
				 // 균형잡힌 문자열 u, v로 분리
				if (left == right) {
					String u = str.substring(0, i+1);
					String v = str.substring(i+1, str.length());
					
					if (isRight(u)) { // u가 올바른 문자열이면
						return u + seperate(v);
					}
					else {
						String tmp = "(" + seperate(v) + ")";

						u = u.substring(1,u.length()-1);
						
						if (!"".equals(u)) {
							for (int j = 0; j < u.length(); j++) {
								if (u.charAt(j) == '(') tmp += ")";
								else tmp += "(";
							}
						}
						return tmp;
					}
				}
			} // end of str for
			return str;
		} // end of seperate

		// 올바른 괄호 문자열인지 판단
		private boolean isRight(String str) {
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				char now = str.charAt(i);
				
				if (now == '(') st.push(now);
				else {
					if (st.size() == 0) st.push(now);
					else {
						char top = st.peek();
						if (top == '(') st.pop();
						else st.push(now);
					}
					
				}
			}
			
			boolean flag = st.isEmpty() ? true : false;
			return flag;
		}
	}
}

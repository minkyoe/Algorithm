package KAKAO;
public class Solution_2020_문자열압축 {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.solution("a"));
	}
	
	
	
	
	static class Solution {
		public int solution(String s) {
			int min = Integer.MAX_VALUE;
			
			int len = s.length();
			
			for (int cnt = 1; cnt <= len/2; cnt++) { // 자를 개수
				String tmp = "";
				int sameCnt = 1;
				
				for (int start = 0; start+cnt <= len-cnt; start+=cnt) { // 문자열 비교 인덱스
					String s1 = s.substring(start, start+cnt);
					String s2 = s.substring(start+cnt, start+cnt+cnt);
					
					if (s1.equals(s2)) {
						++sameCnt;
						if (start+cnt+cnt+cnt > len) {
							tmp += String.valueOf(sameCnt);
							tmp += s.substring(start+cnt, len);
						}

					}
					else {
						if (sameCnt == 1 || "".equals(s2)) {
							tmp += s1;
						} else {
							tmp += String.valueOf(sameCnt);
							tmp += s1;
							sameCnt = 1;
						}
						if (start+cnt+cnt+cnt > len) {
							tmp += s.substring(start+cnt, len);
						}
					}
					
				}
				min = min > tmp.length() ? tmp.length() : min;
			}
			
			if (min == Integer.MAX_VALUE) min = 1;
			
			return min;
		}
	}
}

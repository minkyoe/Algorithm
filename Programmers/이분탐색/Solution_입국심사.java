package 이분탐색;

import java.util.Arrays;

public class Solution_입국심사 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(6,new int[] {7,10}));
	}
	
	static class Solution {
		public long solution(int n, int[] times) {
			long answer = 0;
			
			Arrays.sort(times);
			
			long left = 1;
			long right = n * (long)times[times.length-1];
			long mid = (left+right)/2;
			answer = right;
			
			while (left <= right) {
				long sum = 0;
				mid = (left + right) / 2;
				for (int i = 0; i < times.length; i++) {
					sum += mid / times[i];
				}
				
				if (sum < n) {
					left = mid + 1;
				} else {
	                answer = mid;
	                right = mid - 1;
					
				}
			}
			return answer;
		}
	}
}

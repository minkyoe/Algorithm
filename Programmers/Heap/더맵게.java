package Heap;

import java.util.*;

public class 더맵게 {
	class Solution {
		public int solution(int[] scoville, int K) {
			int answer = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for (int i = 0; i < scoville.length; i++) {
				pq.offer(scoville[i]);
			}

			while (pq.peek() < K) {
				++answer;
				if (pq.size() < 2) {
					answer = -1;
					break;
				}
				int a = pq.poll();
				int b = pq.poll();
				pq.offer(a + b * 2);
			}
			return answer;
		} // end of solution
	} // end of class
}

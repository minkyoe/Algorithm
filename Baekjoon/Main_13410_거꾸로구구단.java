import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13410_거꾸로구구단 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] nums = new int[K];
		
		for (int i = 1; i <= K; i++) {
			nums[i-1] = N * i; 
		}
		
		for (int i = 0; i < K; i++) {
			int n = nums[i];
			String s = String.valueOf(n);
			int reversed = s.charAt(s.length() - 1) - '0';
			
			for (int j = s.length() - 2; j >= 0; j--) {
				reversed = reversed * 10 + (s.charAt(j) - '0');
			}
			
			pq.offer(reversed);
		}

		System.out.println(pq.poll());
	} // end of main

} // end of class

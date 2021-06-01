import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851_숨바꼭질2 {

	private static int N, K, ans;
	private static int minTime;
	private static int[] minTimes;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		minTime = Integer.MAX_VALUE;
		minTimes = new int[100001];
		
		Arrays.fill(minTimes, Integer.MAX_VALUE);
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int time = tmp[1];
			
			if (now == K) {
				if (minTime > time) {
					ans = 1;
					minTime = time;
				} else if (minTime == time) {
					++ans;
				}
			}
			
			for (int i = 0; i < 3; i++) {
				int n = 0;
				if (i == 0) n = now - 1;
				else if (i == 1) n = now + 1;
				else n = now * 2;
				
				if (n < 0 || n > 100000 || minTimes[n] < (time+1)) continue;
				q.offer(new int[] {n, time+1});
				minTimes[n] = (time+1);
			}
		}
		
		System.out.println(minTime);
		System.out.println(ans);
	} // end of main

} // end of class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9489_사촌 {

	private static int n;
	private static int k;
	private static int[] nodes;
	private static int[] parents;
	private static int K;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			if (n == 0 && k == 0) break;
			
			K = 0; ans = 0;
			
			parents = new int[n+1];
			nodes = new int[n+1];
			
			st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				nodes[i] = Integer.parseInt(st.nextToken());
				if (nodes[i] == k) K = i;
			}
			
			int before = nodes[1];
			int idx = 0;
			for (int i = 2; i <= n; i++) {
				if (before + 1 != nodes[i]) {
					++idx;
				}
				before = nodes[i];
				parents[i] = idx;
			}
			
			for (int i = 1; i<= n; i++) {
				if (i == K || i == parents[K] || parents[K] == parents[i]) continue;
				if (parents[parents[K]] == parents[parents[i]]) {
					++ans;
				}
			}
			
			System.out.println(ans);
		} // end of while
	} // end of main

} // end of class

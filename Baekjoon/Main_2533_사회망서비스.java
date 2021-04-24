import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2533_사회망서비스 {

	private static int N;
	private static ArrayList<Integer>[] list;
	private static int[][] dp;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		list = new ArrayList[N+1];
		dp = new int[N+1][2]; // index 아래로 필요한 얼리어답터 수를 저장
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		go(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));

	} // end of main

	private static void go(int idx) {
		visited[idx] = true;
		dp[idx][0] = 0;
		dp[idx][1] = 1;
		
		for (int n : list[idx]) {
			if (visited[n]) continue;
			go(n);
			dp[idx][0] += dp[n][1];
			dp[idx][1] += Math.min(dp[n][0], dp[n][1]);
		}
		
	}

} // end of class

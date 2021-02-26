import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9372_상근이의여행2 {

	private static int N;
	private static int M;
	private static ArrayList<Integer>[] list;
	private static int cnt;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 국가 개수
			M = Integer.parseInt(st.nextToken()); // 비행기 종류 개수
			list = new ArrayList[N+1];
			
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			cnt = 0;
			visited = new boolean[N+1];
			
			visited[1] = true;
			dfs(1);
			
			System.out.println(cnt);
			
		} // end of testCase
	} // end of main

	private static void dfs(int num) {
		for (int i = 0; i < list[num].size(); i++) {
			int now = list[num].get(i);
			if (visited[now]) continue;
			visited[now] = true;
			++cnt;
			dfs(now);
		}
		
	}
} // end of class

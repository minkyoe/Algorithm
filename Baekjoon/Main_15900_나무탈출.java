import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15900_나무탈출 {

	private static int N;
	private static ArrayList<Integer>[] list;
	private static boolean[] visited;
	private static int depth;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		depth = 0;
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		visited[1] = true;
		go(1, 0);
		
		if (depth % 2 == 0) System.out.println("No");
		else System.out.println("Yes");
	} // end of main

	private static void go(int idx, int cnt) {
		boolean flag = false;
		for (int i = 0; i < list[idx].size(); i++) {
			int next = list[idx].get(i);
			if (visited[next]) continue;
			flag = true;
			visited[next] = true;
			go(next, cnt + 1);
			visited[next] = false;
		}
		
		if (!flag) depth += cnt;
		return;
	}

} // end of class

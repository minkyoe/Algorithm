import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10974_모든순열 {

	private static int N;
	private static int[] selected;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		selected = new int[N];
		visited = new boolean[N+1];
		
		go(1, 0);
	} // end of main

	private static void go(int idx, int cnt) {
		if (cnt == N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(selected[i] + " ");
			}
			System.out.println(sb);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[cnt] = i;
			go(i+1, cnt+1);
			visited[i] = false;
		}
		
	}

} // end of class

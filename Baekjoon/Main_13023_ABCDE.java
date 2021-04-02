import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {

	private static int N;
	private static int M;
	private static ArrayList<ArrayList<Integer>> list;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		list = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		boolean ans = false;
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			if (dfs(i, 1)) {
				ans = true;
				break;
			}
			Arrays.fill(visited, false);
		}
		
		if (ans) System.out.println("1");
		else System.out.println("0");
	} // end of main

	private static boolean dfs(int n, int cnt) {
		if (cnt == 5) {
			return true;
		}
		
		for (int i = 0; i < list.get(n).size(); i++) {
			int next = list.get(n).get(i);
			if (visited[next]) continue;
			visited[next] = true;
			if (dfs(next, cnt+1)) return true;
			else {
				visited[next] = false;
				continue;
			}
		}
		return false;
	}

} // end of class

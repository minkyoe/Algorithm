import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16432_떡장수와호랑이 {

	private static int N;
	private static ArrayList<Integer>[] list;
	private static int[] selected;
	private static StringBuilder sb;
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		list = new ArrayList[N];
		selected = new int[N];
		visited = new boolean[N][10];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			st.nextToken();
			
			while(st.hasMoreTokens()) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		sb = new StringBuilder();
		
		if (go(0)) System.out.println(sb);
		else System.out.println("-1");
	} // end of main

	private static boolean go(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(selected[i]).append("\n");
			}
			return true;
		}
		
		for (int i = 0; i < list[cnt].size(); i++) {
			int now = list[cnt].get(i);
			
			if (cnt > 0 && selected[cnt-1] == now) continue;
			if (visited[cnt][now]) continue;
			
			selected[cnt] = now;
			visited[cnt][now] = true;
			
			if ( go(cnt+1) ) return true;
		}
		
		return false;
	}

} // end of class

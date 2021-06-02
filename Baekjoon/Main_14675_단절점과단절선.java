import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14675_단절점과단절선 {

	private static int N, Q;
	private static ArrayList<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // 정점 개수
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N-1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		Q = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= Q; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());	
			boolean flag = true; // 단절점, 단절선이면 false
			
			if (t == 1) {
				if (list[k].size() > 1) flag = false;
			}
			else if (t == 2) {
				flag = false;
			}
			
			if (!flag) sb.append("yes\n");
			else sb.append("no\n");
		}
		
		System.out.println(sb);

	} // end of main

} // end of class

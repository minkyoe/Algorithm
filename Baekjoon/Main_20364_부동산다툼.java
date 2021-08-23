import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20364_부동산다툼 {

	private static int N, Q;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		
		for (int i = 0; i < Q; i++) {
			int goal = Integer.parseInt(bf.readLine());
			int now = goal;
			boolean isBlocked = false;
			int blockSpot = 0;
			
			while (true) {
				if (now == 0) {
					if (isBlocked) sb.append(blockSpot);
					else {
						sb.append(0);
						visited[goal] = true;
					}
					sb.append("\n");
					break;
				}
				
				if (now != 0 && visited[now]) {
					blockSpot = now;
					isBlocked = true;
				}
				
				now /= 2;
			}
		}
		
		System.out.println(sb);
	} // end of main

} // end of class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1956_운동 {

	private static int V;
	private static int E;
	private static int[][] arr;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		arr = new int[V+1][V+1];
		
		for (int j = 1; j <= V; j++) { 
			for (int k = 1; k <= V; k++) { 
				arr[j][k] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a][b] = c;
		}
		
		for (int i = 1; i <= V; i++) { // 경유 
			for (int j = 1; j <= V; j++) { // 출발 
				for (int k = 1; k <= V; k++) { // 도착
					if (i == j || j == k || i == k) continue;
					if (arr[j][i] == Integer.MAX_VALUE || arr[i][k] == Integer.MAX_VALUE) continue;
					
					if (arr[j][k] > arr[j][i] + arr[i][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}
		
		for (int j = 1; j <= V; j++) { 
			for (int k = 1; k <= V; k++) { 
				if (arr[j][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
					ans = Math.min(ans, arr[j][k] + arr[k][j]);
				}
			}
		}
		
		if (ans == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(ans);

	} // end of main 
} // end of class

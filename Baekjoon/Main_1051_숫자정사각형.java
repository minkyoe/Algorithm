import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051_숫자정사각형 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static int min;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		min = Math.min(N, M);
		ans = Integer.MIN_VALUE;
		
		for (int len = 1; len <= min; len++) { // 한변의 길이
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (r + len > N || c + len > M) continue;
					if (map[r][c] == map[r+len-1][c+len-1] && map[r+len-1][c+len-1] == map[r][c+len-1] && map[r][c+len-1] == map[r+len-1][c]) 
						ans = Math.max(ans, len*len);
				}
			}
		}
		System.out.println(ans);
	} // end of main

} // end of class

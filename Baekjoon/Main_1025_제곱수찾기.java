import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1025_제곱수찾기 {
	private static int N, M, ans;
	private static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		ans = -1;
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				go(i, j);
			}
		}
		System.out.println(ans);
	} // end of main
	
	private static boolean isSquare(int n) {
		// 혹은, sqrt * sqrt == n 인지 체크해도 가능
		double num = Double.valueOf(n);
		double sqrt = Math.sqrt(num);
		if (sqrt - (int)(sqrt) > 0) {
			return false;
		}
		return true;
	}
	
	private static void go(int r, int c) {
		int sqr = -1;
		
		for (int dr = N*(-1)+1; dr < N; dr++) { // 공차 
			for (int dc = M*(-1)+1; dc < M; dc++) {
				
				int sum = arr[r][c];

				if (dr == 0 && dc == 0) {
					if (isSquare(sum)) {
						sqr = Math.max(sqr, sum);
					}
					continue;
				}
				
				int nr = r + dr;
				int nc = c + dc;
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				
				while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					sum = sum*10 + arr[nr][nc];
					if (isSquare(sum)) {
						sqr = Math.max(sqr, sum);
					}
					nr += dr;
					nc += dc;
				}
			}
		}
		
		ans = Math.max(ans, sqr);
	}
} // end of class
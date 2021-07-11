import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2167_2차원배열의합 {

	private static int N;
	private static int M;
	private static int K;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		K = Integer.parseInt(bf.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			int fromR = Integer.parseInt(st.nextToken());
			int fromC = Integer.parseInt(st.nextToken());
			int toR = Integer.parseInt(st.nextToken());
			int toC = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			for (int r = fromR; r <= toR; r++) {
				for (int c = fromC; c <= toC; c++) {
					sum += arr[r][c];
				}
			}
			
			System.out.println(sum);
		}

	} // end of main

} // end of class

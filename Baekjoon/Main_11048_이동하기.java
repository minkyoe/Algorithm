import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11048_이동하기 {

	private static int N;
	private static int M;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for (int i = 1; i < N; i++) {
//			for (int j = 1; j < M; j++) {
//				int max = 0;
//				if (max < map[i-1][j-1]) max = map[i-1][j-1];
//				if (max < map[i-1][j]) max = map[i-1][j];
//				if (max < map[i][j-1]) max = map[i][j-1];
//				map[i][j] += max;
//			}
//		}
		for (int i = N-1; i >= 0; i--) {
			for (int j = M-1; j >= 0; j--) {
				int max = 0;
				if (i-1 >= 0 && j-1 >= 0) {
					if (map[i-1][j] < map[i][j-1]) map[i][j-1] += map[i][j];
					else map[i-1][j] += map[i][j];
				} else {
					if (j-1 < 0 && i-1 >= 0) map[i-1][j] += map[i][j];
					else if (i-1 < 0 && j-1 >= 0) map[i][j-1] += map[i][j];
				}
//				if (i-1 >= 0 && max < map[i-1][j]) max = map[i-1][j];
//				if (j-1 >= 0 && max < map[i][j-1]) max = map[i][j-1];
//				map[i][j] += max;
			}
		}
		
		System.out.println(map[0][0]);

	} // end of main

} // end of class

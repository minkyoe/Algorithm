import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Boj_1074_Z_2 {
	static int N, R, C, size;
	static int n = 0; // map에 써줄 숫자

	// 현재위치 우 하 우하
	static int[] dirY = { 0, 0, 1, 1 };
	static int[] dirX = { 0, 1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		recur(size, 0, 0); // 0,0 에서 출발

	} // end of main

	private static void recur(int size, int r, int c) {
		if (size == 2) {
			for (int i = 0; i < dirX.length; i++) {
				int yy = r + dirY[i];
				int xx = c + dirX[i];
				if (yy == R && xx == C) {
					System.out.println(n);
					return;
				}
				n++;
			}
			return;
		}

		recur(size / 2, r, c);
		recur(size / 2, r, c + size / 2);
		recur(size / 2, r + size / 2, c);
		recur(size / 2, r + size / 2, c + size / 2);

		return;
	}

} // end of class

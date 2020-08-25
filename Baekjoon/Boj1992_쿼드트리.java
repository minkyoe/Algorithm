import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Boj_1992_쿼드트리 {

	static int N; // 영상의 크기
	static char[][] map;
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		recur(0, 0, N);

	} // end of main

	private static void recur(int r, int c, int size) {
		if (size == 1) {
			System.out.print(map[r][c]);
			return;
		}

		boolean isConsistent = true;
ex:		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[r][c] != map[i][j]) {
					isConsistent = false;
					break ex;
				}
			}
		}

		if (!isConsistent) {
			System.out.print("(");
			recur(r, c, size / 2);
			recur(r, c + size / 2, size / 2);
			recur(r + size / 2, c, size / 2);
			recur(r + size / 2, c + size / 2, size / 2);
			System.out.print(")");
		} else {
			System.out.print(map[r][c]);
		}

		return;
	} // end of recur

} // end of class

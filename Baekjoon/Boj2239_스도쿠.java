import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 16972KB
 * 396ms
 */
public class 백준_2239_스도쿠_김민경 {

	private static int N;
	private static int[][] board;
	private static int[] row;
	private static int[] col;
	private static int[][] box;
	private static int zeroCnt;
	private static boolean flag;
	private static int[] zeroRow;
	private static int[] zeroCol;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = 9;
		board = new int[N][N];
		row = new int[N];
		col = new int[N];
		box = new int[3][3];
		zeroCnt = 0;
		zeroRow = new int[81];
		zeroCol = new int[81];
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = s.charAt(j) - '0';
				if (board[i][j] == 0) {
					zeroRow[zeroCnt] = i;
					zeroCol[zeroCnt] = j;
					zeroCnt++;
				}
				else {
					row[i] += 1 << board[i][j];
					col[j] += 1 << board[i][j];
					box[i/3][j/3] += 1 << board[i][j];
				}
			}
		}
		
		dfs(0);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	} // end of main

	private static void dfs(int cnt) {
		if (cnt == zeroCnt) {
			flag = true;
			return;
		}
		
		int y = zeroRow[cnt];
		int x = zeroCol[cnt];
		
		for (int k = 1; k <= 9; k++) {
			if (((box[y/3][x/3] & 1 << k) == 0) &&
					((row[y] & 1 << k) == 0) &&
					((col[x] & 1 << k) == 0)) { // 채울 수 있는 숫자
				board[y][x] = k;
				row[y] += 1 << k;
				col[x] += 1 << k;
				box[y/3][x/3] += 1 << k;
				
				dfs(cnt+1);
				if (flag) return;
				
				board[y][x] = 0;
				row[y] -= 1 << k;
				col[x] -= 1 << k;
				box[y/3][x/3] -= 1 << k;
			}
		} // end of for
		
		return;
	}

}

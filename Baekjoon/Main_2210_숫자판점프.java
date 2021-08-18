import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_2210_숫자판점프 {

	private static int[][] map;
	private static HashSet<String> ans;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		ans = new HashSet<String>();
		
		for (int i = 0; i < 5; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < 5; j++, index+=2) {
				map[i][j] = s.charAt(index) - '0';
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, "" + map[i][j]);
			}
		}
		
		System.out.println(ans.size());
	} // end of main

	private static void dfs(int r, int c, String str) {
		if (str.length() == 6) {
			ans.add(str);
			return;
		}
		
		for (int i = 0; i < dc.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
			dfs(nr, nc, str + map[nr][nc]);
		}
	}
} // end of class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {

	private static int N;
	private static int M;
	private static int x;
	private static int y;
	private static int k;
	private static int[][] map, dice;
	private static int[] command;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dice = new int[4][3];
		command = new int[k];
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
			}
		}
		
		String s = bf.readLine();
		for (int i = 0, index = 0; i < k; i++, index += 2) {
			command[i] = s.charAt(index) - '0';
		}
		
		go(x, y);
		
	} // end of main

	// 동 서 북 남 = 우 좌 상 하 
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	private static void go(int r, int c) {
		for (int com : command) {
			int nr = r + dr[com - 1];
			int nc = c + dc[com - 1];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			if (com == 1) { // 동 
				int tmp = dice[1][2];
				dice[1][2] = dice[1][1];
				dice[1][1] = dice[1][0];
				dice[1][0] = dice[3][1];
				dice[3][1] = tmp;
			}
			else if (com == 2) { // 서 
				int tmp = dice[3][1];
				dice[3][1] = dice[1][0];
				dice[1][0] = dice[1][1];
				dice[1][1] = dice[1][2];
				dice[1][2] = tmp;
			}
			else if (com == 3) { // 남  
				int tmp = dice[3][1];
				dice[3][1] = dice[0][1];
				dice[0][1] = dice[1][1];
				dice[1][1] = dice[2][1];
				dice[2][1] = tmp;
			}
			else if (com == 4) { // 북  
				int tmp = dice[3][1];
				dice[3][1] = dice[2][1];
				dice[2][1] = dice[1][1];
				dice[1][1] = dice[0][1];
				dice[0][1] = tmp;
			}
			
			if (map[nr][nc] == 0) map[nr][nc] = dice[3][1];
			else {
				dice[3][1] = map[nr][nc];
				map[nr][nc] = 0;
			}
			System.out.println(dice[1][1]);
			r = nr;
			c = nc;
		} // end of commands
		
	}

} // end of class

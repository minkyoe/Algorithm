import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 핀은 수평, 수직 방향으로 인접한 핀을 뛰어넘어서 그 핀의 다음 칸으로 이동하는 것만 허용된다. 인접한 핀의 다음 칸은 비어있어야 하고 그 인접한 핀은 제거된다.

public class Main_9207_페그솔리테어 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int tc = 0;
	static char[][] map = new char[5][9];
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	private static int oCnt;
	private static int move;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		tc = Integer.parseInt(bf.readLine());
		for (int testCase = 1; testCase <= tc; testCase++) {
			
			oCnt = 8; // 핀의 최대 개수
			move = 0;
			
			for (int i = 0; i < 5; i++) {
				String s = bf.readLine();
				for (int j = 0; j < 9; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			dfs(0);
			
			System.out.println(oCnt + " " + move);
			bf.readLine();
			
			
		} // end of tc
	} // end of main
	
	private static void dfs(int depth) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 'o') {
					
					// 인접 네 방향 체크
					for (int k = 0; k < dirX.length; k++) {
						int ny = i + dirY[k];
						int nx = j + dirX[k];
						
						int nny = ny + dirY[k];
						int nnx = nx + dirX[k];
						
						if (ny < 0 || ny >= 5 || nx < 0 || nx >= 9) continue;
						if (nny < 0 || nny >= 5 || nnx < 0 || nnx >= 9) continue;
						
						if (map[ny][nx] == 'o') {
							if (map[nny][nnx] == '.') {
								map[ny][nx] = '.';
								map[i][j] = '.';
								map[nny][nnx] = 'o';
								dfs(depth+1);
								map[ny][nx] = 'o';
								map[i][j] = 'o';
								map[nny][nnx] = '.';
							}
						}
					}
					
				}
			}
		}
		
		int tmpOCnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 'o') tmpOCnt++;
			}
		}
		if (tmpOCnt < oCnt) {
			oCnt = tmpOCnt;
			move = depth;
		}
		
	} // end of dfs
} // end of class

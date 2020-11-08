import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {

	private static int R;
	private static int C;
	private static int M;
	private static int sum;
	private static int newR;
	private static int newC;
	private static int newDir;
	private static Shark[][] map;
	private static Shark[][] mapCopy;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		sum = 0; // 낚시왕이 잡은 상어 크기의 합
		newR = 0;
		newC = 0;
		newDir = 0;
		map = new Shark[R][C];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if (d == 1) d = 0;
			else if (d == 2) d = 3;
			else if (d == 3) d = 2;
			else d = 1;
			map[r-1][c-1] = new Shark(s,d,z);
		}
		
		
		int kingCol = -1;
		
		while(true) {
			kingCol++; // 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
			if (kingCol == C) break; // 낚시왕은 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동을 멈춘다.
			
			// 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 
			// 2-1. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
			for (int row = 0; row < R; row++) {
				if (map[row][kingCol] != null) {
					sum += map[row][kingCol].z;
					map[row][kingCol] = null;
					break;
				}
			}
			
			// 3. 상어 이동
			mapCopy = new Shark[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					Shark now = map[i][j];
					if (now == null) continue;
					getNewLoc(i, j, now.dir, now.velocity, now.z);
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = mapCopy[i][j];
				}
			}
			
		}
		
		System.out.println(sum);

	} // end of main
	
	// 이동하게될 새 좌표 구하기
	// 0 1 2 3
	// 상 좌 우 하
	private static int[] dr = {-1, 0, 0, 1};
	private static int[] dc = {0, -1, 1, 0};
	private static void getNewLoc(int r, int c, int dir, int velocity, int z) {
		int tr = r;
		int tc = c;
		for (int i = 0; i < velocity; i++) {
			tr += dr[dir];
			tc += dc[dir];
			
			if (tr >= R || tr < 0 || tc >= C || tc < 0) {
				dir = 3-dir; // 방향 바꾸기
				if (tr >= R) {
					tr += dr[dir]*2;
				}
				else if (tr < 0) {
					tr += dr[dir]*2;
				}
				else if (tc >= C) {
					tc += dc[dir]*2;
				}
				else if (tc < 0) {
					tc += dc[dir]*2;
				}
			}
			
		}
		newR = tr;
		newC = tc;
		newDir = dir;
		Shark newShark = new Shark(map[r][c].velocity, newDir, map[r][c].z);
		if (mapCopy[newR][newC] != null && map[r][c].z > mapCopy[newR][newC].z) {
			mapCopy[newR][newC] = newShark;
		} 
		if (mapCopy[newR][newC] == null) {
			mapCopy[newR][newC] = newShark;
		}
	}

} // end of class

class Shark{
	int velocity;
	int dir;
	int z;
	
	public Shark() {
	}

	public Shark(int velocity, int dir, int z) {
		this.velocity = velocity;
		this.dir = dir;
		this.z = z;
	}
}
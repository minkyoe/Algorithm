import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18500_미네랄2 {

	private static int R, C;
	private static char[][] cave;
	private static ArrayList<int[]> floatClusters;
	private static boolean[][] isNotFloated;
	private static int fallDist;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cave = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = bf.readLine();
			for (int j = 0; j < C; j++) {
				cave[i][j] = s.charAt(j);
			}
		}
		
		int tc = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");
		boolean leftTurn = true; // 왼, 오 차례 구분
		
		for (int t = 1; t <= tc; t++) {
			int floor = R - Integer.parseInt(st.nextToken());
			floatClusters = new ArrayList<>();
			
			// 파괴할 미네랄 마주치기
			int column = getMineralColumn(leftTurn, floor);
			
			// 클러스터 좌표 저장
			if (column != -1) {
				cave[floor][column] = '.'; // 일단 마주친 미네랄부터 파괴시킴
				isNotFloated = new boolean[R][C];
				getFloatClusters(); // 공중에 떠 있는 클러스터 구함
				
				// 클러스터 떨어트리기
				fallDist = Integer.MAX_VALUE; // 클러스터가 떨어질 거리
				getDistance();
				fallDown();
			}
			
			// 순서 변경
			leftTurn = !leftTurn;
		} // end of testCase
		
		// 정답 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(cave[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	} // end of main


	private static void fallDown() {
		boolean[][] isChanged = new boolean[R][C];
		for (int i = 0; i < floatClusters.size(); i++) {
			int[] tmp = floatClusters.get(i);
			int r = tmp[0]; int c = tmp[1];
			
			cave[r + fallDist][c] = 'x';
			isChanged[r + fallDist][c] = true;
			if (!isChanged[r][c]) cave[r][c] = '.';
		}	
		
	}


	private static void getDistance() {
		for (int i = 0; i < floatClusters.size(); i++) {
			int[] tmp = floatClusters.get(i);
			int r = tmp[0]; int c = tmp[1];
			int dist = 0;
			
			while (true) {
				++r;
				if (cave[r][c] == '.') {
					++dist;
					if (r == R-1) break;
				}
				else {
					if (!isNotFloated[r][c]) continue; // 미네랄을 만났는데 같은 클러스터의 미네랄이면
													   // 그 미네랄이 떨어질 수 있는 거리를 구해야함
					break;
				}
			}
			
			fallDist = Math.min(fallDist, dist);
		}
	}


	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static void getFloatClusters() {
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		
		// 바닥에 있는 미네랄 큐에 넣기 
		for (int i = 0; i < C; i++) {
			if (cave[R-1][i] == 'x') {
				visited[R-1][i] = true;
				isNotFloated[R-1][i] = true;
				q.offer(new int[] {R-1, i});
			}
		}
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (visited[nr][nc] || cave[nr][nc] == '.') continue;
				
				visited[nr][nc] = true;
				isNotFloated[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		} // end of while
		
		// 떠있는 클러스터 리스트에 넣기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (cave[i][j] == 'x' && !isNotFloated[i][j]) {
					floatClusters.add(new int[] {i, j});
				}
			}
		}
	}

	private static int getMineralColumn(boolean leftTurn, int floor) {
		int column = -1;
		if (leftTurn) { // 맨 왼쪽부터 탐색
			for (int col = 0; col < C; col++) {
				if (cave[floor][col] == 'x') {
					column = col;
					break;
				}
			}
		}
		else { // 맨 오른쪽부터 탐색
			for (int col = C-1; col >= 0; col--) {
				if (cave[floor][col] == 'x') {
					column = col;
					break;
				}
			}
		}
		return column;
	}

} // end of class

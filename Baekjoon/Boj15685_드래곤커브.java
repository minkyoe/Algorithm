import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 0: x좌표가 증가하는 방향 (→) 
 * 1: y좌표가 감소하는 방향 (↑) 
 * 2: x좌표가 감소하는 방향 (←) 
 * 3: y좌표가 증가하는 방향 (↓)
 * 
 * 입력으로 주어지는 드래곤 커브는 격자 밖으로 벗어나지 않는다. 드래곤 커브는 서로 겹칠 수 있다.
 *
 */
public class Main_15685_드래곤커브 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N = 0; // 커브의 개수
	static int x, y, d, g; // 시작점, 시작 방향, 세대

	// 0 1 2 3
	static int[] dirY = { 0, -1, 0, 1 };
	static int[] dirX = { 1, 0, -1, 0 };

	static int[][] route = new int[101][101];
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(bf.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			ArrayList<Integer> Dir = new ArrayList<>();
			Dir.add(d); // 시작 방향 추가
			for (int j = 1; j <= g; j++) { // 1~g세대 까지 (0세대는 위에 이미 넣음)
				for (int k = Dir.size() - 1; k >= 0; k--) {
					Dir.add((Dir.get(k) + 1) % 4); // 4 -> 0
				}
			}
			
			// 방향대로 루트에 점 표기
			route[y][x] = 1; // 시작점
			for (int j = 0; j < Dir.size(); j++) {
				int ny = y + dirY[Dir.get(j)];
				int nx = x + dirX[Dir.get(j)];
				route[ny][nx] = 1;
				y = ny;
				x = nx;
			}

		} // end of curve
		
		

		// 0~100 X 0~100 까지 정사각형 개수 세기
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (route[j][k] == 1 && route[j + 1][k] == 1 && route[j][k + 1] == 1 && route[j + 1][k + 1] == 1) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	} // end of main
} // end of class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] wheel = new char[5][8]; // 0번 인덱스 안씀 , 1~4번 휠
	static char[][] wheelCopy = new char[5][8]; // 0번 인덱스 안씀 , 1~4번 휠
	static int K = 0; // 회전 횟수
	static int[][] rotate; // 회전정보 담은 배열
	static boolean[] visited = new boolean[5]; // 0번 인덱스 안씀
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 4; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = str.charAt(j);
			}
		}

		copy(); // 바퀴 배열 복사

		K = Integer.parseInt(bf.readLine());
		rotate = new int[K][2];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				rotate[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			int rotateWheel = rotate[i][0];
			int dir = rotate[i][1];
			visited[rotateWheel] = true;
			dfs(rotateWheel, dir);
			visited[rotateWheel] = false;

			copy();
		}

		if (wheel[1][0] == '1')
			ans += 1;
		if (wheel[2][0] == '1')
			ans += 2;
		if (wheel[3][0] == '1')
			ans += 4;
		if (wheel[4][0] == '1')
			ans += 8;

		System.out.println(ans);

	} // end of main

	private static void copy() {
		for (int i = 1; i <= 4; i++) {
			System.arraycopy(wheel[i], 0, wheelCopy[i], 0, 8);
		}
	}

	private static void dfs(int rotateWheel, int dir) {

		// 해당 바퀴 회전
		rotate(rotateWheel, dir);

		// 양옆 바퀴 확인
		if (rotateWheel - 1 >= 1 && !visited[rotateWheel - 1]
				&& wheelCopy[rotateWheel - 1][2] != wheelCopy[rotateWheel][6]) {
			visited[rotateWheel - 1] = true;
			dfs(rotateWheel - 1, dir * -1); // 전 바퀴 회전
			visited[rotateWheel - 1] = false;
		}
		if (rotateWheel + 1 <= 4 && !visited[rotateWheel + 1]
				&& wheelCopy[rotateWheel + 1][6] != wheelCopy[rotateWheel][2]) {
			visited[rotateWheel + 1] = true;
			dfs(rotateWheel + 1, dir * -1); // 뒤 바퀴 회전
			visited[rotateWheel + 1] = false;
		}

	}

	private static void rotate(int rotateWheel, int dir) {
		char[][] copy = new char[1][8];
		for (int i = 0; i < 8; i++) {
			copy[0][i] = wheel[rotateWheel][i];
		}

		for (int j = 0; j < 8; j++) {
			if (dir == 1)
				wheel[rotateWheel][(j + 1) % 8] = copy[0][j % 8];
			if (dir == -1)
				wheel[rotateWheel][(8 - j) % 8] = copy[0][(8 - j + 1) % 8];
		}
	}

} // end of class

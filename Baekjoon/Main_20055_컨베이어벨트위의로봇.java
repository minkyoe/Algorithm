import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {

	private static int N;
	private static int K;
	private static int up, down;
	private static int stage, zeroCnt;
	private static int[] map;
	private static int[] robot;
	private static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		q = new LinkedList<>();
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		up = 0; // 올라가는 위치
		down = N-1; // 내려가는 위치
		stage = 0; // 단계 수 
		zeroCnt = 0; // 내구도 0인 칸 개수
		
		st = new StringTokenizer(bf.readLine(), " ");
		map = new int[2*N]; // 벨트 내구도
		robot = new int[2*N]; // 로봇 여부
		
		// 입력받기
		for (int i = 0; i < 2*N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		while (zeroCnt < K) {
			
			stage++;
			// 1. 벨트 한칸 회전
			beltRotate();
			
			// 2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 
			//	만약 이동할 수 없다면 가만히 있는다.
			// 	로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
			robotRotate();
			
			// 3. 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
			if (robot[up] == 0 && map[up] >= 1) {
				robot[up] = 1;
				map[up] -= 1;
				if (map[up] == 0) zeroCnt++;
				q.offer(up);
			}
		}
		
		System.out.println(stage);
		
	} // end of main

	private static void robotRotate() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int now = q.poll();
			int next = now + 1;
			if (next >= 2*N) next = 0;
			// 내려가는 위치에 로봇이 있는 경우 로봇은 반드시 땅으로 내려가야 한다. 
			if (now == down) {
				robot[now] = 0;
				continue;
			}
			
			if (robot[next] == 0 && map[next] >= 1) {
				// 이동
				robot[now] = 0;
				map[next] -= 1;
				if (map[next] == 0) zeroCnt++;
				// 내려가는 위치에 로봇이 있는 경우 로봇은 반드시 땅으로 내려가야 한다. 
				if (next == down) { // 다음 위치가 내려가는 위치라면 
					continue;
				}
				robot[next] = 1;
				q.offer(next);
				// 로봇이 어떤 칸에 올라가거나 이동하면 그 칸의 내구도는 즉시 1만큼 감소한다.
			} else {
				q.offer(now);
			}
			
		}
	}

	private static void beltRotate() {
		if (up-1 < 0) up = 2*N-1;
		else up -= 1;
		
		if (down-1 < 0) down = 2*N-1;
		else down -= 1;
		
		
	}
	
	private static void check(int[][] tmp) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
	}

} // end of class

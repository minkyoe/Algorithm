package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	private static int[][] map;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0; // 청소한 영역 개수
		
		st = new StringTokenizer(bf.readLine(), " ");
		Robot robot = new Robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < M; j++,index+=2) {
				map[i][j] = s.charAt(index) - '0';
			}
		}
		
		boolean noMoreClean = false;
ex:		while (true) {
			if (map[robot.r][robot.c] == 0) {
				map[robot.r][robot.c] = 2; // 청소
				cnt++;
			}
			
			for (int i = 1; i <= 4; i++) {
				int nr = robot.r + dir[(robot.dir + 3) % 4][0];
				int nc = robot.c + dir[(robot.dir + 3) % 4][1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					robot.dir = (robot.dir + 3) % 4; // 회전
					continue;
				}
				if (map[nr][nc] == 0) {
					robot.dir = (robot.dir + 3) % 4; // 회전
					robot.r = robot.r + dir[robot.dir][0]; // 한칸 전진
					robot.c = robot.c + dir[robot.dir][1];
					continue ex;
				} else {
					robot.dir = (robot.dir + 3) % 4; // 회전
				}
			}
			
			// 뒤쪽 방향 확인
			int br = robot.r + dir[robot.dir][0]*(-1);
			int bc = robot.c + dir[robot.dir][1]*(-1);
			if (br < 0 || br >= N || bc < 0 || bc >= M || map[br][bc] == 1) noMoreClean = true;
			else { // 뒤에 벽이 아니거나 범위 안벗어나면 한칸 후진
				robot.r = br;
				robot.c = bc;
			}
			
			if (noMoreClean) break;
		} // end of while
		
		System.out.println(cnt);
		
		
	} // end of main
} // end of class
class Robot {
	int r;
	int c;
	int dir;
	
	
	public Robot(int r, int c, int dir) {
		super();
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
	public Robot() {
		// TODO Auto-generated constructor stub
	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_16236_아기상어_김민경 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int N; // 공간의 크기
	static int eat; // 먹은 횟수
	
	static int[][] map;
	static Shark baby;
	static boolean[][] visited;
	
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	
	static ArrayList<Fish> Fishes = new ArrayList<>(); // 먹을 수 있는 물고기 담은 리스트
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < N; j++, index+=2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 9) baby = new Shark(i, j, 0, 2, 0);
			}
		}
		
		int time = 0;
		while (true) {
			// 초기화
			Fishes.clear();
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
			
			BFS();
			
			if (Fishes.size() == 0) break;
			else {
				Collections.sort(Fishes);
				
				int eatY = Fishes.get(0).y;
				int eatX = Fishes.get(0).x;
				int	dist = Fishes.get(0).dist;
				
				// 아기 상어 위치 이동
				map[baby.y][baby.x] = 0;
				baby.y = eatY;
				baby.x = eatX;
				map[baby.y][baby.x] = 9;
				
				// 시간 갱신
				time += dist;
				// 크기 갱신
				if (++baby.eat == baby.size) {
					baby.size++;
					baby.eat = 0;
				}
			}
			
		} // end of while
		
		System.out.println(time);
		
	} // end of main

	private static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {baby.y, baby.x, 0});
		visited[baby.y][baby.x] = true;
		
		while(!q.isEmpty()) {
			int[] tmp= q.poll();
			int y = tmp[0];
			int x = tmp[1];
			int move = tmp[2];
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny>=N || nx < 0 || nx >= N) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] > baby.size) continue; // 자신보다 큰 물고기로 이동 못함
				
				visited[ny][nx] = true;
				if (map[ny][nx] != 9 && map[ny][nx] > 0 && map[ny][nx] < baby.size) { // 자신보다 작은 물고기 먹을 수 있음
					Fishes.add(new Fish(ny, nx, move+1));
				}
				q.offer(new int[] {ny, nx, move+1});
			}
		}
		
	}
} // end of class

class Shark {
	int y;
	int x;
	int eat;
	int size;
	int time;
	
	public Shark() {
	}

	public Shark(int y, int x, int eat, int size, int time) {
		super();
		this.y = y;
		this.x = x;
		this.eat = eat;
		this.size = size;
		this.time = time;
	}
}

class Fish implements Comparable<Fish>{
	int y;
	int x;
	int dist; // 아기상어와의 거리
	
	public Fish() {
	}

	public Fish(int y, int x, int dist) {
		super();
		this.y = y;
		this.x = x;
		this.dist = dist;
	}

	@Override
	public int compareTo(Fish o) {
		if (this.dist == o.dist) {
			if (this.y == o.y) {
				return Integer.compare(this.x, o.x);
			}
			return Integer.compare(this.y, o.y);
		}
		return Integer.compare(this.dist, o.dist);
	}

}
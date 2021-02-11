import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {

	private static class Loc {
		int r;
		int c;
		
		Loc (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	private static int N;
	private static int M;
	private static int[][] map;
	private static ArrayList<Loc> virus;
	private static ArrayList<Integer> selected;
	private static int ans;
	private static Queue<int[]> q;
	private static int canSpread;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken()); // 연구소 크기 
		M = Integer.parseInt(st.nextToken()); // 바이러스 개수
		map = new int[N][N];
		virus = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		canSpread = 0; // (바이러스가 퍼질 수 있는) 빈칸 수
		
		// 0은 빈 칸, 1은 벽, 2는 바이러스의 위치
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < N; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 2) {
					virus.add(new Loc(i,j));
				} else if (map[i][j] == 0) {
					canSpread++;
				}
			}
		}
		
		// 바이러스 조합
		selected = new ArrayList<>();
		comb(0, 0);
		
		// 정답 출력
		if (ans == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(ans);

	} // end of main

	private static void comb(int idx, int cnt) {
		if (cnt == M) {
			make();
			spread();
		}
		
		for (int i = idx; i < virus.size(); i++) {
			selected.add(i);
			comb(i+1, cnt+1);
			selected.remove(selected.size()-1);
		}
		
	}

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int[][] copy;
	
	private static void spread() {
		int time = 0;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int tt = tmp[2];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (map[nr][nc] != 1 && copy[nr][nc] == -1) { // 벽이 아니고 들른 적이 없다면
					copy[nr][nc] = tt+1;
					q.offer(new int[] {nr, nc, tt+1});
					
					if (map[nr][nc] == 0){
						cnt++;
					}
				}
			}
		}
		if (cnt == canSpread) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copy[i][j] != -1 && map[i][j] != 2) {
						time = Math.max(time, copy[i][j]);
					}
				}
			}
			ans = Math.min(ans, time);
		}
	}

	private static void make() {
		q = new LinkedList<>();
		copy = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = -1;
			}
		}
		
		// 활성화 구분
		for (int i = 0; i < selected.size(); i++) {
			q.add(new int[] {virus.get(selected.get(i)).r, virus.get(selected.get(i)).c, 0});
			copy[virus.get(selected.get(i)).r][virus.get(selected.get(i)).c] = 0;
		}
		
	}

	private static void check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) System.out.print("- ");
				else System.out.print(copy[i][j] + " ");
				
			}
			System.out.println();
		}
	}

} // end of class

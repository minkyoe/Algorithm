import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2_2 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int N, M; // 세로, 가로
	static int[][] map;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[] parents;
	static int ans = 0; // 최소 비용
	static ArrayList<Edge> list;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0,index = 0; j < M; j++, index+=2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 1) map[i][j] = -1;
			}
		}
		
		// 1. 섬 번호 붙이기
		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					BFS(i,j,idx++);
				}
			}
		}
		
		// 2. 각 섬의 최단거리 구해서 인접 리스트 만들기 (거리가 1이면 간선으로 치지 않음)
		list = new ArrayList<Edge>();
		for (int i = 1; i < idx; i++) {
			getMinEdge(i);
		}
		Collections.sort(list);
		
		// 3. 최소 비용 구하기
		parents = new int[idx];
		for (int i = 1; i <= idx-1; i++) {
			parents[i] = i;
		}
		int cnt = 0;
		if (list.size() == 0) {
			System.out.println("-1");
			System.exit(0);
		}
		for (Edge e : list) {
			if (cnt == idx-2) break;
			if (union(e.from,e.to)) {
				++cnt;
				ans += e.weight;
			}
		}
		
		if (cnt != idx-2) ans = -1;
		
		System.out.println(ans);
		
		
	} //end of main


	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}


	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}


	private static void getMinEdge(int idx) {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == idx) {
					for (int d = 0; d < dx.length; d++) {
						int len = 0;
						int y = i;
						int x = j;
						
						while (true) {
							int ny = y + dy[d];
							int nx = x + dx[d];
							
							if (ny < 0 || ny >= N || nx < 0 || nx >= M) break;
							if (map[ny][nx] == idx) break;
							
							if (map[ny][nx] == 0) {
								len++;
								y = ny;
								x = nx;
							}
							else { // 다른 섬 인덱스 나왔을때
								if (len <= 1) break;
								else { 
									list.add(new Edge(idx, map[ny][nx], len));
									break;
								}
							}
						} // end of While
					} // end of dir For
				}
			}
		}
		
	}


	private static void BFS(int r, int c, int idx) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.offer(new int[] {r,c});
		map[r][c] = idx; 
		visited[r][c] = true;
		
		while(!q.isEmpty() ) {
			int[] tmp = q.poll();
			int y = tmp[0];
			int x = tmp[1];
			
			for (int i = 0; i < dy.length; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] != -1) continue;
				
				map[ny][nx] = idx;
				visited[ny][nx] = true;
				q.offer(new int[] {ny, nx});
					
			}
			
		}
		
		
	}

} // end of class
class Edge implements Comparable<Edge>{
	int from;
	int to;
	int weight;
	
	public Edge() {
	}

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
}

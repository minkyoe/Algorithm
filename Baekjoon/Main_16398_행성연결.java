import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16398_행성연결 {

	private static int N;
	private static int[][] map;
	private static int[] parent;
	private static PriorityQueue<Vertex> pq;
	
	static class Vertex implements Comparable<Vertex>{
		int from;
		int to;
		int weight;
		
		Vertex(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Vertex v) {
			return this.weight - v.weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		parent = new int[N];
		pq = new PriorityQueue<Vertex>(); 
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) 
					pq.offer(new Vertex(i, j, map[i][j]));
			}
		}
		
		long ans = 0;
		
		while (!pq.isEmpty()) {
			Vertex tmp = pq.poll();
			if (!union(tmp.to, tmp.from)) continue;
			ans += tmp.weight;
		}
		
		System.out.println(ans);
	} // end of main
	
	public static int getParent(int a) {
		if (a == parent[a]) return a;
		return parent[a] = getParent(parent[a]);
	}
	
	public static boolean union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if (a == b) return false;
		parent[b] = a;
		return true;
	}

} // end of class

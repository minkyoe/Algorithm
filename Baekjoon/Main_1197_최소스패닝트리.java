import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
	
	static class Vertex implements Comparable<Vertex>{
		int a;
		int b;
		int weight;
		
		Vertex (int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}

	private static int V,E;
	private static PriorityQueue<Vertex> pq;
	private static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<Vertex>();
		parents = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new Vertex(a, b, w));
		}

		long ans = 0;
		while(!pq.isEmpty()) {
			Vertex tmp = pq.poll();
			if (union(tmp.a, tmp.b)) {
				ans += tmp.weight;
			}
		}
		System.out.println(ans);
	} // end of main
	
	public static boolean union(int a, int b) {
		int ar = findRoot(a);
		int br = findRoot(b);
		if (ar == br) return false;
		parents[br] = ar;
		return true;
	}
	
	public static int findRoot(int a) {
		if (a == parents[a]) return a;
		return parents[a] = findRoot(parents[a]);
	}

} // end of class

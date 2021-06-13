import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_6497_전력난 {

	private static int m, n, used, total;
	private static ArrayList<Integer>[] list;
	private static int[] parents;
	private static class House implements Comparable<House>{
		int from;
		int to;
		int dist;
		
		House (int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		public int compareTo(House o) {
			return this.dist - o.dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if (m == 0 && n == 0) break;
			used = 0; total = 0;
			
			list = new ArrayList[m];
			for (int i = 0; i < m; i++) {
				list[i] = new ArrayList<>();
			}
			
			parents = new int[m];
			for (int i = 0; i < m; i++) {
				parents[i] = i;
			}
			
			PriorityQueue<House> pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				pq.add(new House (a, b, c));
				total += c;
			}
			
			int connected = 0;
			while (!pq.isEmpty()) {
				House tmp = pq.poll();
				if (union(tmp.from, tmp.to)) {
					used += tmp.dist;
					++connected;
				}
				if (connected == m-1) break;
			}
			System.out.println(total - used);
		}
		
	}
	
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		parents[b] = a;
		return true;
	}
	
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

}

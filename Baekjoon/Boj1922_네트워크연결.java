import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M; // 컴퓨터 수, 간선 수
	static ArrayList<Edge> list = new ArrayList<>();
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		parents = new int[N+1]; // 1부터 시작
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Edge(from, to, weight));
		}
		
		Collections.sort(list);
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		int cnt = 0; 
		int result = 0; // 최소비용 
		for (Edge e : list) {
			if (cnt == N-1) {
				break;
			}
			if (union(e.from, e.to)) {
				cnt++;
				result += e.weight;
			}
		}
		System.out.println(result);
		
	} // end of main

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
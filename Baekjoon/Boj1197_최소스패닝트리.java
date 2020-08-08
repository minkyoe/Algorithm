import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E; // 정점 개수 , 간선 개수
	static int[] parent;
	static ArrayList<Edge> al = new ArrayList<Edge>();
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parent = new int[V + 1]; // 0번 안씀
		make(); // parent 배열 초기화

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			al.add(new Edge(a, b, c));
		}

		Collections.sort(al);

		for (int i = 0; i < al.size(); i++) {
			int a = al.get(i).a;
			int b = al.get(i).b;
			if (union(a, b)) {
				sum += al.get(i).weight;
			}
		}
		System.out.println(sum);
	} // end of main

	private static boolean union(int a, int b) {
		int ap = findSet(a);
		int bp = findSet(b);
		if (ap == bp)
			return false;
		parent[bp] = ap;
		return true;
	}

	private static int findSet(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = findSet(parent[a]); // path compression
	}

	/** parent 배열 초기화 */
	private static void make() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
} // end of class

class Edge implements Comparable<Edge> {
	int a;
	int b;
	int weight;

	public Edge() {
	}

	public Edge(int a, int b, int weight) {
		super();
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}

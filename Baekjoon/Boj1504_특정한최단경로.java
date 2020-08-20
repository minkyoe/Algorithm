import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, E; // 정점 개수, 간선 개수

	private static List<Node>[] list;
	private static int[] dist;
	static final int INF = 16_000_0000;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수

		list = new ArrayList[N + 1];
		dist = new int[N + 1];

		Arrays.fill(dist, INF);

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
			list[v].add(new Node(u, w));
		}

		st = new StringTokenizer(bf.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

		int ans = (result1 > result2) ? result2 : result1;

		System.out.println(ans >= INF ? "-1" : ans);

	} // end of main

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		Arrays.fill(dist, INF);
		q.add(new Node(start, 0));
		dist[start] = 0;

		while (!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.end;

			if (check[cur])
				continue;
			check[cur] = true;

			for (Node node : list[cur]) {
				if (dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					q.add(new Node(node.end, dist[node.end]));
				}
			}
		}
		return dist[end];

	}

} // end of class

class Node implements Comparable<Node> {
	int end, weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}

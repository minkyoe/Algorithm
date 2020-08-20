import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E, K; // 정점 개수, 간선 개수, 시작 정점
	private static List<Node>[] list;
	private static int[] dist;
	static final int INF = 3000000;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		K = Integer.parseInt(bf.readLine()); // 시작 정점

		list = new ArrayList[V + 1];
		dist = new int[V + 1];

		Arrays.fill(dist, INF);

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		// u에서 v로 가는 가중치 w인 간선이 존재
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}

		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}

	} // end of main

	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] check = new boolean[V + 1];
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

	}

} // end of class

//class Node implements Comparable<Node> {
//	int end, weight;
//
//	public Node(int end, int weight) {
//		this.end = end;
//		this.weight = weight;
//	}
//
//	@Override
//	public int compareTo(Node o) {
//		return weight - o.weight;
//	}
//}

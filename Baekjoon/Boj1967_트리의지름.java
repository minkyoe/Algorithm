package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1967_트리의지름 {
	private static int n;
	static ArrayList<Node>[] list;
	private static boolean[] visited;
	private static int maxDist;
	private static int end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		int ans = 0;
		
		list = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		StringTokenizer st;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int son = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[parent].add(new Node(son, weight));
			list[son].add(new Node(parent, weight));
		}
		
		visited = new boolean[n+1];
		end = 0;
		maxDist = 0;
		
		visited[1] = true;
		dfs(1, 0);

		maxDist = 0;
		visited = new boolean[n+1];
		visited[end] = true;
		
		dfs(end, 0);
		ans += maxDist;
		
		System.out.println(ans);
	} // end of main

	private static void dfs(int parent, int dist) {
		
		if (dist > maxDist) {
			maxDist = dist;
			end = parent;
		}
		
		for (int i = 0; i < list[parent].size(); i++) {
			int now = list[parent].get(i).son;
			int w = list[parent].get(i).weight;
			if (visited[now]) continue;
			visited[now] = true;
			dfs(now, dist + w);
			
		}
		return;
	}
} // end of class

class Node {
	int son;
	int weight;
	
	public Node() {
	}

	public Node(int son, int weight) {
		super();
		this.son = son;
		this.weight = weight;
	}
	
	
}

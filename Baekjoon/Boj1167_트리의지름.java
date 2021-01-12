package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1167_트리의지름 {

	private static int V;
	private static ArrayList<Vertex>[] list;
	private static boolean[] visited;
	private static int ans;
	private static int farVertex;
	
	static class Vertex {
		int v;
		int w;
		
		Vertex(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(bf.readLine()); // 정점의 개수
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		ans = 0;
		farVertex = 0;
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1) break;
				list[v].add(new Vertex(num, Integer.parseInt(st.nextToken())));
			}
		}
		
		dfs(1, 0);
		
		ans = 0;
		Arrays.fill(visited, false);
		
		dfs(farVertex, 0);
		
		System.out.println(ans);
		
	} // end of main

	private static void dfs(int v, int sum) {
		visited[v] = true;
		
		if (ans < sum) {
			ans = sum;
			farVertex = v;
		}
		
		for (int i = 0; i < list[v].size(); i++) {
			int now = list[v].get(i).v;
			int len = list[v].get(i).w;
			if (v == now || visited[now]) continue;
			dfs(now, sum + len);
			visited[now] = false;
		}
		
	}

} // end of class

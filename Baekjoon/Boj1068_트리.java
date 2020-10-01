package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer; 

public class Main_1068_트리 {
	private static int N; // 노드 개수
	private static int deleteNum;
	private static int cnt;
	private static int root;
	private static boolean[] visited;
	private static ArrayList<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		cnt = 0;
		root = 0;
		visited = new boolean[N];
		
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int np = Integer.parseInt(st.nextToken());
			
			if (np == -1) {
				root = i;
				continue;
			}
			list[np].add(i);
		}
		deleteNum = Integer.parseInt(bf.readLine());
		if (root == deleteNum) {
			System.out.println(0);
			System.exit(0);
		}
		
		visited[deleteNum] = true;
		bfs(root);
		System.out.println(cnt);
		
	} // end of main

	private static void bfs(int root) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(root);
		visited[root] = true;
		
		while(!q.isEmpty()) {
			int leaf = 0;
			int now = q.poll();
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				
				if (visited[next]) continue;
				++leaf;
				q.offer(next);
			}
			
			if (leaf == 0) ++cnt;
		}
		
	}
} // end of class

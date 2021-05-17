package 코드챌린지;

import java.util.ArrayList;

public class 모두0으로만들기 {
	public static void main(String[] args) {
		int[] a = {-5,0,2,1,2};
		int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
		
		long ans = solution(a, edges);
		System.out.println(ans);
	} // end of main

	private static long[] sum;
	private static boolean[] visited;
	private static ArrayList<Integer>[] list;
	private static long tmpAns = 0;
	public static long solution(int[] a, int[][] edges) {
		long answer = 0;
		list = new ArrayList[a.length];
		visited = new boolean[a.length];
		sum = new long[a.length];
		
		long tmp = 0;
		for (int i = 0; i < a.length; i++) {
			sum[i] = a[i];
			tmp += a[i];
			list[i] = new ArrayList<Integer>();
		}
		
		if (tmp != 0) return -1;
		else {
			for (int i = 0; i < edges.length; i++) {
				int aa = edges[i][0];
				int bb = edges[i][1];
				list[aa].add(bb);
				list[bb].add(aa);
			}
			
			dfs(0);
			answer = tmpAns;
			return tmpAns;
		}
		
	}
	private static long dfs(int now) {
		visited[now] = true;
		for (int i = 0; i < list[now].size(); i++) {
			int other = list[now].get(i);
			if (visited[other]) continue;
			sum[now] += dfs(other);
		}
		tmpAns += Math.abs(sum[now]);
		return sum[now];
	}
} // end of class

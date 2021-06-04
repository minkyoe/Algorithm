import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17073_나무위의빗물 {

	private static int N;
	private static double W, leaf;
	private static ArrayList<Integer>[] list;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		W = Double.parseDouble(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		leaf = 0; // 단말 노드 개수
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			boolean isLeaf = true;
			
			for (int i = 0; i < list[now].size(); i++) {
				int son = list[now].get(i);
				
				if (visited[son]) continue;
				
				isLeaf = false;
				visited[son] = true;
				q.offer(son);
			}
			
			if (isLeaf) ++leaf;
		}
		
		System.out.println(W / leaf);
	} // end of main

} // end of class

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @author minkyoe
 * maxSpot을 ArrayList 대신 HashSet으로 풀면 틀림..
 *
 */
public class Main_6118_숨바꼭질 {

	private static int N; // 헛간 개수, 2 <= N <= 20,000
	private static int M; // 길의 개수 (양방향), 1<= M <= 50,000
	private static int maxDist;
//	private static HashSet<Integer> maxSpot;
	private static int maxCnt;
	private static ArrayList<Integer>[] map;
	private static boolean[] visited;
	private static ArrayList maxSpot;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		maxDist = 0;
//		maxSpot = new HashSet<>();
		maxSpot = new ArrayList<>();
		maxCnt = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		
		bfs(1);
		Collections.sort(maxSpot);
//		Iterator<Integer> it = maxSpot.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		System.out.println(maxSpot.get(0) + " " + maxDist + " " + maxCnt);

	} // end of main

	private static void bfs(int v) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {v, 0});
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int now = t[0];
			int cnt = t[1];
			
			if (maxDist < cnt) {
				maxDist = cnt;
				maxCnt = 1;
				maxSpot.clear();
				maxSpot.add(now);
			}
			else if (maxDist == cnt) {
				maxCnt++;
				maxSpot.add(now);
			}
			
			for (int i = 0; i < map[now].size(); i++) {
				int tmp = map[now].get(i);
				if (visited[tmp]) continue;
				q.offer(new int[] {tmp, cnt+1});
				visited[tmp] = true;
			}
			
		}
		
	}

} // end of class

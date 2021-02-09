import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 선행 작업 중에 가장 늦게 끝나는 시간부터 현재 작업 시작
// 4번 작업의 선행 작업이 1, 2번이라고 치고 각각 5, 10초 걸린다면 
// 4번은 10초부터 작업 시작해야함

public class Main_2056_작업 {

	private static int N;
	private static ArrayList<Integer>[] list;
	private static int[] indegree;
	private static int[] time;
	private static int[] cost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		list = new ArrayList[N+1]; // 뒤에 연결된 작업들
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		indegree = new int[N+1]; // 진입차수 개수
		time = new int[N+1]; // 각 작업에서 걸리는 시간
		cost = new int[N+1]; // 누적 작업 시간
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			time[i] = a;
			int b = Integer.parseInt(st.nextToken());
			indegree[i] = b;
			
			for (int j = 0; j < b; j++) {
				int job = Integer.parseInt(st.nextToken());
				list[job].add(i);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
				cost[i] = time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				
				cost[next] = Math.max(cost[next], time[next] + cost[now]);
				indegree[next] -= 1;
				if (indegree[next] == 0) q.offer(next);
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (ans < cost[i]) ans = cost[i];
		}
		
		System.out.println(ans);
	} // end of main

} // end of class

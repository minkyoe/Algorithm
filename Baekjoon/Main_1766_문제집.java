import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1766_문제집 {

	private static int N, M;
	private static int[] indegree; // 진입 차수
	private static ArrayList<Integer> problems[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N+1];
		problems = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			problems[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			indegree[b] += 1;
			problems[a].add(b);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) pq.offer(i);
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			System.out.print(now + " ");
			
			for (int i = 0; i < problems[now].size(); i++) {
				int next = problems[now].get(i);
				if (--indegree[next] == 0) pq.offer(next);
			}
		}

	} // end of main
} // end of class

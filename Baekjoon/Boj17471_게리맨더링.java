import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 구역 개수
	static int[] people; // 인구수
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); // 인접 리스트
	static int ans = Integer.MAX_VALUE;
	// 구역 나누기
	static ArrayList<Integer> district1 = new ArrayList<Integer>(); // visited 1
	static ArrayList<Integer> district2 = new ArrayList<Integer>(); // visited 0
	static boolean[] selected;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		people = new int[N+1]; // 1~N구역 인구 수
		selected = new boolean[N+1];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int j = 0; j < cnt; j++) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			list.add(tmp);
		}
		
		go(1, 0); // idx, cnt
		
		if (ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
		
	} // end of main


	private static void go(int idx, int cnt) {
		if (cnt > 0) {
			district1.clear();
			district2.clear();
			
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 1; i <= N; i++) {
				if (selected[i]) {
					district1.add(i);
					sum1 += people[i];
				}
				else {
					district2.add(i);
					sum2 += people[i];
				}
			}
			
			if (district1.size() > 0 && district2.size() > 0 && check(district1, 1) && check(district2, 2)) {
				int diff = Math.abs(sum1-sum2);
				ans = ans > diff ? diff : ans;
			}
		}
		
		for (int i = idx; i <= N; i++) {
			if (cnt == 0 && i == 2) break;
			if(selected[i]) continue;
			selected[i] = true;
			go(i+1, cnt+1);
			selected[i] = false;
		}
	}


	private static boolean check(ArrayList<Integer> district, int disIdx) {
		boolean[] visited = new boolean[N+1]; // 0 인덱스 안씀
		Queue<Integer> q = new LinkedList<>();
		q.offer(district.get(0));
		visited[district.get(0)] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < list.get(now-1).size(); i++) {
				int next = list.get(now-1).get(i);
				if (visited[next]) continue;
				if (disIdx == 1 && district2.contains(Integer.valueOf(next))) continue;
				if (disIdx == 2 && district1.contains(Integer.valueOf(next))) continue;
				
				q.offer(next);
				visited[next] = true;
			}
		}
		
		for (int i = 0; i < district.size(); i++) {
			if (!visited[district.get(i)]) return false;
		}
		
		return true;
	}

} // end of class 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M2_2 {

	private static int N, M;
	private static int[] nums;
	private static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N+1];
		selected = new int[M];
		
		for (int i = 1; i <= N; i++) {
			nums[i] = i;
		}
		
		go(1, 0);

	} // end of main

	private static void go(int idx, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			selected[cnt] = i;
			go(i+1, cnt+1);
		}
	}

} // end of class

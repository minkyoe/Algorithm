import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16922_로마숫자만들기 {

	private static int N, ans;
	private static boolean[] visited;
	private static int[] selected;
	private static int[] num = {1, 5, 10, 50};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		visited = new boolean[50*N+1];
		selected = new int[N];
		ans = 0;
		
		go(0, 0);
		
		System.out.println(ans);
	} // end of main

	private static void go(int idx, int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += selected[i];
			}
			if (!visited[sum]) {
				visited[sum] = true;
				++ans;
			}
			return;
		}
		
		for (int i = idx; i < num.length; i++) {
			selected[cnt] = num[i];
			go(i, cnt+1);
		}
	}

} // end of class

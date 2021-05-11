import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15666_N과M12 {

	private static int N, M;
	private static int[] arr;
	private static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		selected = new int[M];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		go(0, 0);
	} // end of main

	private static void go(int cnt, int idx) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		int before = -1;
		for (int i = idx; i < N; i++) {
			if (before == arr[i]) continue;
			selected[cnt] = arr[i];
			before = arr[i];
			go(cnt+1, i);
		}
		
	}

} // end of class

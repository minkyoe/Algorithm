import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656_N과M7 {

	private static StringBuilder sb;
	private static int N;
	private static int M;
	private static int[] num;
	private static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		selected = new int[M];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		go(0);
		System.out.println(sb);
	} // end of main

	private static void go(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			selected[cnt] = num[i];
			go(cnt+1);
		}
		
	}

} // end of class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655_N과M6 {

	private static int N;
	private static int M;
	private static int[] num;
	private static int[] selected;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		selected = new int[M];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		sb = new StringBuilder();
		comb(0, 0);
		System.out.println(sb);
	} // end of main

	private static void comb(int idx, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < selected.length; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < N; i++) {
			selected[cnt] = num[i];
			comb(i+1, cnt+1);
		}
	}

} // end of class

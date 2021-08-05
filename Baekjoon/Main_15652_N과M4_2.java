import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_N과M4_2 {

	private static int M;
	private static int N;
	private static int[] selected;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		
		sb = new StringBuilder();
		comb(1, 0);
		System.out.println(sb);
	}

	private static void comb(int num, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = num; i <= N; i++) {
			selected[cnt] = i;
			comb(i, cnt+1);
		}
		
	}
}

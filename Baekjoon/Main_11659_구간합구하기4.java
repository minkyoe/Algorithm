import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_구간합구하기4 {

	private static int N, M;
	private static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum = new int[N+1];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i < sum.length; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + n;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			System.out.println(sum[to] - sum[from-1]);
		}

	} // end of main

} // end of class

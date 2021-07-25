import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {

	private static int N;
	private static int[] num;
	private static int[] sign;
	private static boolean[] visited;
	private static int[] selected;
	private static int max;
	private static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		num = new int[N];
		sign = new int[N-1];
		visited = new boolean[N-1];
		selected = new int[N-1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int end = Integer.parseInt(st.nextToken());
			for (int j = 0; j < end; j++) {
				sign[idx++] = i;
			}
		}
		
		go(0, 0);
		
		System.out.println(max);
		System.out.println(min);
	} // end of main

	private static void go(int idx, int cnt) {
		if (cnt == N-1) {
			int sum = num[0];
			for (int i = 1; i < num.length; i++) {
				if (selected[i-1] == 0) {
					sum += num[i];
				}
				else if (selected[i-1] == 1) {
					sum -= num[i];
				}
				else if (selected[i-1] == 2) {
					sum *= num[i];
				}
				else {
					sum /= num[i];
				}
			}
			
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < sign.length; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[cnt] = sign[i];
			go(0, cnt + 1);
			visited[i] = false;
		}
		
	}

} // end of class

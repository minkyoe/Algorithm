import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {

	private static int N, ans;
	private static int[][] arr;
	private static boolean[] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		arr = new int[N+1][N+1];
		selected = new boolean[N+1];
		ans = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go(1, 0); // idx, cnt
		System.out.println(ans);
		
	} // end of main
	private static void go(int idx, int cnt) {
		if (cnt == N/2) {
			int trueSum = 0;
			int falseSum = 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j || selected[i] != selected[j]) continue;
					if (selected[i]) {
						trueSum += arr[i][j];
					} else {
						falseSum += arr[i][j];
					}
				}
			}
			
			int tmp = Math.abs(trueSum - falseSum);
			ans = Math.min(ans, tmp);
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			selected[i] = true;
			go(i + 1, cnt + 1);
			selected[i] = false;
		}
	}

} // end of class

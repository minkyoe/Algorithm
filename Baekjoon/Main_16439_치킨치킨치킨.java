import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16439_치킨치킨치킨 {

	private static int N, M, ans;
	private static int[][] arr;
	private static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 회원 수 
		M = Integer.parseInt(st.nextToken()); // 치킨 종류 수
		ans = Integer.MIN_VALUE;
		arr = new int[N][M];
		selected = new int[3];
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				arr[i][j] = s.charAt(index) - '0';
			}
		}
		
		go(0, 0);
		System.out.println(ans);
	} // end of main

	private static void go(int idx, int cnt) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int biggest = Math.max(Math.max(arr[i][selected[0]], arr[i][selected[1]]), arr[i][selected[2]]);
				sum += biggest;
			}
			ans = ans < sum ? sum : ans;
			return;
		}
		
		for (int i = idx; i < M; i++) {
			selected[cnt] = i;
			go(i+1, cnt+1);
		}
	}

} // end of class

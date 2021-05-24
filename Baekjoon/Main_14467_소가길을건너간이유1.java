import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14467_소가길을건너간이유1 {

	private static int N, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int[] cowCnt = new int[11];
		int[] cowIdx = new int[11];
		ans = 0;
		
		for (int i = 1; i <= 10; i++) {
			cowIdx[i] = -1;
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int cow = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if (cowIdx[cow] == -1) {
				cowIdx[cow] = idx;
			} else if (cowIdx[cow] != idx) {
				cowCnt[cow] += 1;
				cowIdx[cow] = idx;
			}
		}
		
		for (int i = 1; i <= 10; i++) {
			if (cowCnt[i] == 0) continue;
			ans += cowCnt[i];
		}
		System.out.println(ans);
	} // end of main

} // end of class

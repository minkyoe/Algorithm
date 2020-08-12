import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1456_거의소수 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		int ans = 0;

		int[] isDeleted = new int[10_000_001];
		isDeleted[0] = isDeleted[1] = 1;

		for (int i = 2; i < isDeleted.length; i++) {
			for (int j = i + i; j < isDeleted.length; j += i) {
				if (isDeleted[j] == 0) {
					isDeleted[j] = 1;
				}
			}
		}

		for (int i = 2; i < isDeleted.length; i++) {
			if (isDeleted[i] == 0) { // 소수이면
				int cnt = 2;
ex: 			while (true) {
					long n = (long) Math.pow(i, cnt); // cnt제곱
					if (a <= n && n <= b) {
						ans++;
					}

					if (n > b) {
						break ex;
					}
					cnt++;
				}
			}
		}

		System.out.println(ans);
	} // end of main
} // end of class

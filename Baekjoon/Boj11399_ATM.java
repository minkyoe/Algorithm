import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 사람 수
	static int[] arr;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];

		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			ans += sum;
		}
		System.out.println(ans);

	} // end of main
} // end of class

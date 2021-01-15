import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138_한줄로서기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ans = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int cnt = arr[i];
			
			for (int j = 1; j <= N; j++) {
				if (ans[j] > 0 && ans[j] < i) continue;
				else if (ans[j] == 0 && cnt == 0) {
					ans[j] = i;
					break;
				}
				else cnt--;
			}
			
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(ans[i] + " ");
		}
	} // end of main

} // end of class

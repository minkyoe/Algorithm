import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1292_쉽게푸는문제 {

	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		ans = 0;
		
		int idx = 1;
		int n = 1;
		
		while (true) {
			for (int i = idx; i < idx + n; i++) {
				if (from <= i && i <= to) {
					ans += n;
				}
				if (i >= to) break;
			}
			
			idx += n;
			++n;
			
			if (idx > to) break;
		}
		
		System.out.println(ans);
	} // end of main

} // end of class

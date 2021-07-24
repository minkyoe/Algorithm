import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14912_숫자빈도수 {

	private static int n;
	private static int d;
	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			String s = String.valueOf(i);
			
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) - '0' == d) {
					++cnt;
				}
			}
		}

		System.out.println(cnt);
	} // end of main

} // end of class

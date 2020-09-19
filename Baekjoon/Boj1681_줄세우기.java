import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_줄세우기 {
	static int N, L;
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int num = 0;
		for (int i = 1; i <= N; i++) {
			++num;
			while(String.valueOf(num).contains(String.valueOf(L))) {
				++num;
			}
		}
		
		System.out.println(num);
		
	} // end of main

} // end of class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1547_공 {

	private static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(bf.readLine());
		
		int now = 1; // 공의 현재 컵 위치
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == now) {
				now = b;
			}
			else if (b == now) {
				now = a;
			}
		}
		
		System.out.println(now);
	} // end of main

} // end of class

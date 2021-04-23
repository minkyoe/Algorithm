import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1072_게임 {

	private static long X, Y;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		X = Long.parseLong(st.nextToken()); // 게임 횟수 
		Y = Long.parseLong(st.nextToken()); // 이긴 게임 횟수
		long per = (Y*100 / X);
		if (per >= 99) System.out.println("-1");
		else {
			int left = 0;
			int right = 1_000_000_000;
			int mid = 0;
			
			while (left <= right) {
				mid = (left + right) / 2;
				long result = ((Y+mid)*100/(X+mid));
				if (result > per) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			
			System.out.println(left);
		}
	} // end of main

} // end of class

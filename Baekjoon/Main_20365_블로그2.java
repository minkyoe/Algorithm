import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20365_블로그2 {

	private static int N, bCnt, rCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		bCnt = rCnt = 0;
		
		String s = bf.readLine();
		char before = s.charAt(0);
		String sub = "";
		StringBuilder sb = new StringBuilder(); sb.append(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char now = s.charAt(i);
			if (before != now) sb.append(now);
			before = now;
		}
		
		sub = sb.toString();
		for (int i = 0; i < sub.length(); i++) {
			if (sub.charAt(i) == 'B') ++bCnt;
			else ++rCnt;
		}
		
		if (bCnt >= rCnt) System.out.println(1 + rCnt);
		else System.out.println(1 + bCnt);
	} // end of main
} // end of class

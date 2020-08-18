import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2661_좋은수열 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int N; // 수열 길이
	static boolean endFlag = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		
		dfs("");

	} // end of main
	
	
	private static void dfs(String str) {
		if (str.length() == N) {
			System.out.println(str);
			endFlag = true;
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			if (isValid(str+i)) dfs(str+i);
			if (endFlag) return;
		}
		
	}


	private static boolean isValid(String str) {
		int len = str.length();
		for (int start = 0; start < len; start++) { // 시작 인덱스 
ex:			for (int cnt = 1; cnt <= len/2; cnt++) { // 개수
				if (start+cnt+cnt > len) break ex;
				String str1 = str.substring(start,start+cnt);
				String str2 = str.substring(start+cnt, start+cnt+cnt);
				if (str1.equals(str2)) {
					return false;
				}
			}
		}
		return true;
	}

} // end of class

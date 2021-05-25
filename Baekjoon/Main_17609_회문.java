import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 회문이면 0, 유사 회문이면 1, 둘 모두 아니면 2
public class Main_17609_회문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < T; i++) {
			String s = bf.readLine();
			int len = s.length();
			int left = 0;
			int right = len-1;
			int pass1 = 0;
			int pass2 = 0;
			
			// right가 이동
			while (left < right) {
				char a = s.charAt(left);
				char b = s.charAt(right);
				
				if (a != b) {
					while (left < right) {
						right--;
						pass1++;
						if (s.charAt(left) == s.charAt(right)) {
							break;
						}
					}
				}
				left++;
				right--;
			}
			
			// left가 이동
			left = 0;
			right = len - 1;
			while (left < right) {
				char a = s.charAt(left);
				char b = s.charAt(right);
				
				if (a != b) {
					while (left < right) {
						left++;
						pass2++;
						if (s.charAt(left) == s.charAt(right)) {
							break;
						}
					}
				}
				left++;
				right--;
			}
			
			if (pass1 > 2 && pass2 > 2) System.out.println("2");
			else System.out.println(Math.min(pass1, pass2));
		}

	} // end of main

} // end of class
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1343_폴리오미노 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringBuilder sb = new StringBuilder();
		
		boolean isAvailable = true; // 정답이 나올 수 없는 케이스인지 flag
		int dot = 0; // . 개수
		int x = 0; // X 개수
		
ex:		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == '.') {
				++dot;
				
				// x개수가 0이 될때까지 
				// 0개가 될 수 없다면 정답이 될 수 없음
				while (x > 0) {
					if (x >= 4) {
						x -= 4;
						sb.append("AAAA");
					} else {
						if (x < 2) {
							isAvailable = false;
							break ex;
						} else {
							x -= 2;
							sb.append("BB");
						}
					}
				}
			}
			else if (c == 'X') {
				// 현재까지 쌓인 . 개수만큼 
				for (int j = 0; j < dot; j++) {
					sb.append(".");
				}
				dot = 0; // . 개수 초기화 
				++x;
			}
		}
		
		// 채우지 못한 x가 있다면 
		while (x > 0) {
			if (x >= 4) {
				x -= 4;
				sb.append("AAAA");
			} else {
				if (x < 2) {
					isAvailable = false;
					break;
				} else {
					x -= 2;
					sb.append("BB");
				}
			}
		}
			
		// 채우지 못한 .이 있다면
		for (int i = 0; i < dot; i++) {
			sb.append(".");
		}
		
		// 정답 출력
		if (isAvailable) System.out.println(sb);
		else System.out.println(-1);
		
	} // end of main

} // end of class

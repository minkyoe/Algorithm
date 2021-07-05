import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1032_명령프롬프트 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		char[][] strs = new char[N][50];
		
		for (int i = 0; i < N; i++) {
			strs[i] = bf.readLine().toCharArray();
		}
		
		int to = strs[0].length; // 어느 인덱스까지 비교해야하는지 
		
		StringBuilder sb = new StringBuilder(); // 정답 문자열
		
		for (int i = 0; i < to; i++) {
			int row = 0;
			boolean allSame = true; // 같은 위치의 알파벳이 모두 같은지
			
			while (row < N-1) {
				if (strs[row][i] != strs[row + 1][i]) {
					allSame = false;
					break;
				}
				++row;
			}
			
			if (allSame) {
				sb.append(strs[0][i]);
			} else {
				sb.append('?');
			}
		}
		
		System.out.println(sb);
	} // end of main

} // end of class

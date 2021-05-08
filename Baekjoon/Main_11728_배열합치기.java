import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11728_배열합치기 {

	private static int[] sizes;
	private static int[] fArr;
	private static int[] sArr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sizes = new int[2];
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < sizes.length; i++) {
			sizes[i] = Integer.parseInt(st.nextToken());
		}
		
		fArr = new int[sizes[0]];
		sArr = new int[sizes[1]];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < fArr.length; i++) {
			fArr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < sArr.length; i++) {
			sArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int fIdx = 0; int sIdx = 0;  int ansIdx = 0;
		int[] ans = new int[sizes[0] + sizes[1]];
		
		while (fIdx < fArr.length && sIdx < sArr.length) {
			int fNum = fArr[fIdx];
			int sNum = sArr[sIdx];
			
			if (fNum > sNum) {
				ans[ansIdx++] = sNum;
				sIdx++;
			} else if (fNum < sNum) {
				ans[ansIdx++] = fNum;
				fIdx++;
			} else {
				ans[ansIdx++] = fNum;
				ans[ansIdx++] = sNum;
				sIdx++; fIdx++;
			}
		}
		
		while (fIdx <fArr.length) {
			ans[ansIdx++] = fArr[fIdx++];
		}
		
		while (sIdx <sArr.length) {
			ans[ansIdx++] = sArr[sIdx++];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans.length; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	} // end of main

} // end of class

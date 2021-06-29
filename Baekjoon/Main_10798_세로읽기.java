import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10798_세로읽기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[5][15];
		int[] colLen = new int[5];
		int max = -1;
		
		for (int i = 0; i < 5; i++) {
			arr[i] = bf.readLine().toCharArray();
			colLen[i] = arr[i].length;
			if (max < arr[i].length) max = arr[i].length;
		} // end of for
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (colLen[j] <= i) continue;
				
				sb.append(arr[j][i]);
			}
		}
		
		System.out.println(sb);

	} // end of main

} // end of class

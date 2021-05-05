import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2096_내려가기 {

	private static int N;
	private static int[][] min;
	private static int[][] max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		min = new int[2][3];
		max = new int[2][3];
		StringBuilder sb = new StringBuilder();
		
		String s = bf.readLine();
		for (int i = 0, index = 0; i < 3; i++, index += 2) {
			min[0][i] = s.charAt(index) - '0';
			max[0][i] = min[0][i];
		}
		
		if (N == 1) {
			sb.append(Math.max(Math.max(max[0][0], max[0][1]), max[0][2]) + " ");
			sb.append(Math.min(Math.min(min[0][0], min[0][1]), min[0][2]));
		} else {
			for (int i = 1; i < N; i++) { // 행 
				s = bf.readLine();
				
				for (int j = 0, index = 0; j < 3; j++, index += 2) { // 열
					min[1][j] = s.charAt(index) - '0';
					max[1][j] = min[1][j];
				}
				
				min[1][0] += Math.min(min[0][0], min[0][1]);
				min[1][2] += Math.min(min[0][1], min[0][2]);
				min[1][1] += Math.min(Math.min(min[0][0], min[0][1]), min[0][2]);

				max[1][0] += Math.max(max[0][0], max[0][1]);
				max[1][2] += Math.max(max[0][1], max[0][2]);
				max[1][1] += Math.max(Math.max(max[0][0], max[0][1]), max[0][2]);
				
				min[0][0] = min[1][0];
				min[0][1] = min[1][1];
				min[0][2] = min[1][2];

				max[0][0] = max[1][0];
				max[0][1] = max[1][1];
				max[0][2] = max[1][2];
			}
		}

		sb.append(Math.max(Math.max(max[0][0], max[0][1]), max[0][2]));
		sb.append(" ");
		sb.append(Math.min(Math.min(min[0][0], min[0][1]), min[0][2]));
		
		System.out.println(sb);
	} // end of main

} // end of class

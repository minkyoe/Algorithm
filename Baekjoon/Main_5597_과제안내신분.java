import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5597_과제안내신분 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isSubmitted = new boolean[31];
		
		for (int i = 1; i <= 28; i++) {
			int n = Integer.parseInt(bf.readLine());
			isSubmitted[n] = true;
		}

		int[] notSubmit = new int[2];
		int idx = 0;
		for (int i = 1; i <= 30; i++) {
			if (!isSubmitted[i]) {
				notSubmit[idx++] = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(Math.min(notSubmit[0], notSubmit[1])).append("\n").append(Math.max(notSubmit[0], notSubmit[1]));
		System.out.println(sb);

	} // end of main

} // end of class

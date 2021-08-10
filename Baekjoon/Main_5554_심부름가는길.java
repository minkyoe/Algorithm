import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5554_심부름가는길 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		
		for (int i = 0; i < 4; i++) {
			int time = Integer.parseInt(bf.readLine());
			
			sum += time;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(sum / 60).append("\n");
		sb.append(sum - (60 * (sum/60)));
		
		System.out.println(sb);
	} // end of main

} // end of class

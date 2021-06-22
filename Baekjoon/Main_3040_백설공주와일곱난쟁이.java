import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040_백설공주와일곱난쟁이 {

	private static int[] nums;
	private static int[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		nums = new int[9];
		selected = new int[7];
		
		for (int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(bf.readLine()); 
		}
		
		select(0, 0, 0);
		
		for (int i = 0; i < 7; i++) {
			System.out.println(selected[i]);
		}
	} // end of main

	private static boolean select(int idx, int cnt, int sum) {
		if (cnt == 7) {
			if (sum == 100) return true;
			return false;
		}
		
		for (int i = idx; i < 9; i++) {
			selected[cnt] = nums[i];
			if (select(i+1, cnt+1, sum + nums[i])) return true;
		}
		
		return false;
	}

} // end of class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_14405_피카츄 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		boolean isAns = true;
		
		ArrayList<String> strs = new ArrayList<>();
		strs.add("pi");
		strs.add("ka");
		strs.add("chu");
		
		for (int i = 0; i < s.length(); i++) {
			if (i + 2 > s.length()) {
				isAns = false;
				break;
			}
			
			String tmp = s.substring(i, i+2);
			
			if (!strs.contains(tmp)) {
				if (i + 3 > s.length()) {
					isAns = false;
					break;
				}
				
				tmp = s.substring(i, i+3);
				if (!strs.contains(tmp)) {
					isAns = false;
					break;
				} else {
					i += 2;
				}
			} else {
				i += 1;
			}
		}
		
		if (isAns) System.out.println("YES");
		else System.out.println("NO");

	} // end of main

} // end of class

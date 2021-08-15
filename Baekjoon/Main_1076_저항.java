import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1076_저항 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
		HashMap<String, Integer> multiple = new HashMap<>();
		HashMap<String, Integer> value = new HashMap<>();
		int n = 1;
		
		for (int i = 0; i < colors.length; i++) {
			multiple.put(colors[i], n);
			value.put(colors[i], i);
			n *= 10;
		}
		
		String ans = "";
		
		for (int i = 0; i < 3; i++) {
			String color = bf.readLine();
			if (i < 2) {
				ans += value.get(color);
			}
			else {
				ans = String.valueOf(Long.parseLong(ans) * multiple.get(color));
			}
		}
		
		if (ans.charAt(0) == '0') System.out.println("0");
		else System.out.println(ans);
	} // end of main

} // end of class

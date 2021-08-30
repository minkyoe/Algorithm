import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2789_유학금지 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		
		ArrayList<Character> list = new ArrayList<>();
		list.add('C');
		list.add('A');
		list.add('M');
		list.add('B');
		list.add('R');
		list.add('I');
		list.add('D');
		list.add('G');
		list.add('E');
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (list.contains(c)) continue;
			sb.append(c);
		}
		
		System.out.println(sb);
	} // end of main

} // end of class

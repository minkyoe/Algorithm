package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1991_트리의순회 {
	private static ArrayList[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		list = new ArrayList[N];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			char idx = s.charAt(0);
			ArrayList<Character> tmp = new ArrayList<>();
			for (int j = 1,index=2; j < 3; j++,index+=2) {
				tmp.add(s.charAt(index));
			}
			list[idx-65] = tmp;
		}
		
		pre('A'); System.out.println();
		mid('A'); System.out.println();
		post('A');
		
	} // end of main

	private static void post(char c) {
		if (!list[c-65].get(0).equals('.')) {
			post((char)(list[c-65].get(0)));
		}
		if (!list[c-65].get(1).equals('.')) {
			post((char)(list[c-65].get(1)));
		}
		System.out.print(c);
	}

	private static void mid(char c) {
		if (!list[c-65].get(0).equals('.')) {
			mid((char)(list[c-65].get(0)));
		}
		System.out.print(c);
		if (!list[c-65].get(1).equals('.')) {
			mid((char)(list[c-65].get(1)));
		}
	}

	private static void pre(char c) {
		System.out.print(c);
		if(!list[c-65].get(0).equals('.')) { // 좌 공백일때
			pre((char)(list[c-65].get(0)));
		}
		if(!list[c-65].get(1).equals('.')) { // 좌 공백일때
			pre((char)(list[c-65].get(1)));
		}
	}
} // end of class

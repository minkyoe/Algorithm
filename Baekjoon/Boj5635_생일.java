package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_5635_생일 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		ArrayList<Person1> list = new ArrayList<>();
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			list.add(new Person1(name, day, month, year));
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(list.size()-1).name);
		System.out.println(list.get(0).name);
		
		
	}

}

class Person1 implements Comparable<Person1> {
	String name;
	int day;
	int month;
	int year;
	
	public Person1(String name, int day, int month, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int compareTo(Person1 o) {
		if (this.year == o.year) {
			if (this.month == o.month) {
				return this.day - o.day;
			}
			return this.month - o.month;
		}
		return this.year - o.year;
	}
}

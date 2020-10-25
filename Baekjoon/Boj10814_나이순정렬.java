package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_10814_나이순정렬 {
	private static int N;
	private static ArrayList<Person> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		list = new ArrayList<Person>();
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
			System.out.println(p.age + " " + p.name);
		}
	} // end of main
}
class Person implements Comparable<Person> {
	int age;
	String name;
	
	public Person() {}
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int compareTo(Person o) {
		return this.age - o.age;
	}
	
}

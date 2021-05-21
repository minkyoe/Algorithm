import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1713_후보추천하기 {

	private static int N, T;
	private static ArrayList<Integer> frames;
	private static int[] students;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // frame 수 
		T = Integer.parseInt(bf.readLine()); 
		students = new int[101]; // 학생이 받은 추천 수
		frames = new ArrayList<Integer>(); 
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < T; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if (frames.size() == 0) {
				frames.add(now);
				students[now] += 1;
			}
			else {
				if (frames.contains(now)) students[now] += 1;
				else {
					students[now] += 1;
					if ((frames.size()+1) > N) {
						int minIdx = 0; // frames에서 삭제하기 위해 인덱스 저장
						int minNum = 0; // 학생 번호
						int minVal = Integer.MAX_VALUE;
						
						for (int j = 0; j < frames.size(); j++) {
							int tmp = frames.get(j);
							int cnt = students[tmp];
							
							if (cnt < minVal) {
								minVal = cnt;
								minNum = tmp;
								minIdx = j;
							}
						}
						frames.remove(minIdx);
						students[minNum] = 0;
					}
					frames.add(now);
				}
			}
		}
		
		Collections.sort(frames);
		
		for (int i = 0; i < frames.size(); i++) {
			System.out.print(frames.get(i) + " ");
		}
		 
	} // end of main

} // end of class

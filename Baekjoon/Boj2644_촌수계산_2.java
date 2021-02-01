import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//10
//7 6
//9
//1 2
//1 3
//1 4
//2 7
//2 8
//3 5
//3 6
//9 1
//9 10
public class Boj2644_ÃÌ¼ö°è»ê_2 {

	private static int N;
	private static int[] arr;
	private static ArrayList<Integer> list;
	private static int M;
	private static ArrayList<Integer> roots;
	private static ArrayList listA;
	private static ArrayList listB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N + 1];
		list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		list.add(Integer.parseInt(st.nextToken()));
		list.add(Integer.parseInt(st.nextToken()));

		if (list.get(0) == list.get(1))
			System.out.println(0);
		else {

			M = Integer.parseInt(bf.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

//		for (int i = 1; i <= N; i++) {
//			System.out.print(i + "\t");
//		}
//		System.out.println();

			roots = new ArrayList<>();
//			for (int i = 1; i <= N; i++) {
//				if (i == arr[i]) roots.add(i);
//				System.out.print(arr[i] + "\t");
//			}

//		for (int i = 0; i < roots.size(); i++) {
//			int root = roots.get(i);
//			
//			for (int j = 0; j < 2; j++) {
//				int num = list.get(i);
//				
//			}
//		}

			int ans = 0;
//			listA = new ArrayList<>();
//			listB = new ArrayList<>();
			for (int i = 0; i < 2; i++) {
				int num = list.get(i);
				int tmp = recur(num, 0);
			System.out.println("tmp " + tmp);
				if (tmp == -1) {
					ans = -1;
					break;
				}
				ans += tmp;
			}

			if (ans == 0)
				ans = -1;
			System.out.println(ans);
		}
	} // end of main

	private static int recur(int num, int cnt) {
		System.out.println("num " + num +" / arr[num] " + arr[num]);
		
		if (num == arr[num]) {
			return cnt;
		}
		if (roots.contains(arr[num])) return cnt+1;
		else roots.add(arr[num]);
		
		return recur(arr[num], cnt + 1);
	}

	private static void union(int a, int b) {
		int ra = getParent(a);
		int rb = getParent(b);
		if (ra != rb)
			arr[b] = a;
	}

	private static int getParent(int a) {
		if (a == arr[a])
			return a;
		return arr[a] = getParent(arr[a]);
	}

} // end of class

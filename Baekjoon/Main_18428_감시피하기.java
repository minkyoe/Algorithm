import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_18428_감시피하기 {

	private static int N;
	private static char[][] map;
	private static ArrayList<Pos> empty;
	private static ArrayList<Pos> students;
	private static int emptyCnt;
	private static int[] selected;
	
	static class Pos {
		int r;
		int c;
		
		Pos (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new char[N][N];
		empty = new ArrayList<>();
		students = new ArrayList<>();
		selected = new int[3];
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < N; j++, index += 2) {
				map[i][j] = s.charAt(index);
				if (map[i][j] == 'X') empty.add(new Pos(i, j));
				else if (map[i][j] == 'S') students.add(new Pos(i, j));
			}
		}
		
		emptyCnt = empty.size();
		if (comb(0, 0)) System.out.println("YES");
		else System.out.println("NO");
	} // end of main

	private static boolean comb(int idx, int cnt) {
		if (cnt == 3) {
			if (check()) return true;
			return false;
		}
		
		for (int i = idx; i < emptyCnt; i++) {
			selected[cnt] = i;
			if (comb(i+1, cnt+1)) return true;
		}
		
		return false;
	} // end of comb

	// true이면 감시 다 피할 수 있음
	private static boolean check() {
		char[][] copy = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		
		for (int i = 0; i < 3; i++) {
			int r = empty.get(selected[i]).r;
			int c = empty.get(selected[i]).c;
			copy[r][c] = 'O';
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int i = 0; i < students.size(); i++) {
			int sr = students.get(i).r;
			int sc = students.get(i).c;
			
			for (int j = 0; j < dc.length; j++) {
				int nr = sr;
				int nc = sc;
				
				while(true) {
					nr += dr[j];
					nc += dc[j];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
					if (copy[nr][nc] == 'O') break;
					if (copy[nr][nc] == 'T') return false;
				}
			}
		}
		return true;
	} // end of check

} // end of class

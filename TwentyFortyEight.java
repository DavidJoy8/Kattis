import java.util.Scanner;

public class TwentyFortyEight {
	public static int[][] grid;
	public static boolean[][] alreadyMerged;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		grid = new int[4][4];
		alreadyMerged = new boolean[4][4];
		String[] in;
		for(int i=0;i<4;i++) {
			in = scan.nextLine().split(" ");
			for(int j=0;j<4;j++) {
				grid[i][j] = Integer.parseInt(in[j]);
			}
		}
		int dir = Integer.parseInt(scan.nextLine());
		int dr = iff(-1,dir==1) + iff(1,dir==3);
		int dc = iff(-1,dir==0) + iff(1,dir==2);
		if(dir==0 || dir==1) {
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(grid[i][j] != 0)
						slide(i,j,dr,dc);
				}
			}
		}
		else {
			for(int i=3;i>-1;i--) {
				for(int j=3;j>-1;j--) {
					if(grid[i][j] != 0)
						slide(i,j,dr,dc);
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println(grid[i][3]);
		}
	}

	public static void slide(int r, int c, int dr, int dc) {
		int i=1;
		while(safeCheck(r+i*dr,c+i*dc)==0)
			i++;
		if(safeCheck(r+i*dr,c+i*dc)==grid[r][c] && !alreadyMerged[r+i*dr][c+i*dc]){
			grid[r][c]=0;
			grid[r+i*dr][c+i*dc]*=2;
			alreadyMerged[r+i*dr][c+i*dc] = true;
		}
		else {
			if(i!=1) {
				grid[r+(i-1)*dr][c+(i-1)*dc] = grid[r][c];
				grid[r][c]=0;
			}
		}
	}

	public static int safeCheck(int r, int c) {
		if(r<0 || r>3 || c<0 || c>3)
			return -1;
		return grid[r][c];
	}

	public static int iff(int n, boolean b) {
		if(b)
			return n;
		return 0;
	}
}
import java.util.Scanner;

public class ThreeDStatues {
	public static void main(String[] args) {
		System.out.println(getDays(1,Integer.parseInt(new Scanner(System.in).nextLine())));
	}

	public static int getDays(int p, int s) {	//printers you have, statues left
		if(p>=s)
			return 1;
		if(2*p>=s)
			return 2;
		return 1+getDays(2*p,s);
	}
}
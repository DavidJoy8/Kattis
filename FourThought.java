import java.util.*;

public class FourThought {
	public static HashMap<Integer,String> answers;
	public static final String[] ops = new String[] {"+","-","*","/"};

	public static void main(String[] args) {
		setUp();
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int a;
		for(int i=0;i<n;i++) {
			a = Integer.parseInt(scan.nextLine());
			if(answers.containsKey(a))
				System.out.println(answers.get(a));
			else
				System.out.println("no solution");
		}
	}

	private static void setUp() {
		answers = new HashMap<Integer,String>();
		int temp;
		for(String a:ops) {
			for(String b:ops) {
				for(String c:ops) {
					temp = evaluate(new String[] {"4",a,"4",b,"4",c,"4"});
					answers.put(temp,"4 "+a+" 4 "+b+" 4 "+c+" 4 = "+temp);
				}
			}
		}
	}

	private static int evaluate(String[] ex) {
		if(ex.length==1)
			return Integer.parseInt(ex[0]);
		int[] indexes = new int[ops.length];
		for(int i=0;i<indexes.length;i++)
			indexes[i]=iOf(ex,ops[i]);
		if(indexes[2]==-1 && indexes[3]==-1)
			return evaluate(newArr(ex,positiveMin(indexes[0],indexes[1])));
		return evaluate(newArr(ex,positiveMin(indexes[2],indexes[3])));
	}

	private static String[] newArr(String[] in, int index) {
		String[] out = new String[in.length-2];
		for(int i=0;i<index-1;i++)
			out[i]=in[i];
		out[index-1] = Integer.toString(doMath(in[index],Integer.parseInt(in[index-1]),Integer.parseInt(in[index+1])));
		for(int i=index;i<out.length;i++)
			out[i]=in[i+2];
		return out;
	}

	private static int doMath(String op, int a, int b) {
		if(op.equals("+"))
			return a+b;
		if(op.equals("-"))
			return a-b;
		if(op.equals("*"))
			return a*b;
		return a/b;
	}

	private static int iOf(String[] a, String s) {
		for(int i=0;i<a.length;i++) {
			if(a[i].equals(s))
				return i;
		}
		return -1;
	}

	private static int positiveMin(int a, int b) {
		if(a<1)
			return b;
		if(b<1)
			return a;
		return Math.min(a,b);
	}
}
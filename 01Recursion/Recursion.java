public class Recursion{
    public static String name(){
	return "Lin,John";
    }
    public static double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return helper(n, n);
    }
    private static double helper(double n, double guess){
	if (n == 0){
	    return 0;
	}
	if ((guess * guess - n) / n <= 0.000000001) {
	    return guess;
	}
	return helper(n, (n / guess + guess) / 2);
    }
    public static void main(String[]a){
	System.out.println(sqrt(0));
	System.out.println(sqrt(-5));
	System.out.println(sqrt(16.0 / 9));
    }
}

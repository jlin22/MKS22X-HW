import java.util.*;
public class StackCalc{
    public static double eval(String x){
	String[] tokens = x.split(x);
	Stack<Double> values = new Stack<Double>();
	for (String token:tokens){
	    if(isOperator(token)){
		values.push(apply(token,values.pop(),values.pop()));
	    }
	    else{
		values.push(Double.parseDouble(token));
	    }
	}
	return values.pop();
    }
    private String[] split(String x){
	int y = 0;
	int z = 0;
	String[] a = new String[x.length()];
	for (int i = 0; i < x.length(); i++){
	    if (x.charAt(i) == ' '){
		a[y] = x.substring(z,i);
		y++;
		z = i;
	    }
	}
	return a;	       		   
    }
    private static boolean isOperator(String x){
	return x.equals("+")||x.equals("-")||x.equals("*")||x.equals("/")
	    ||x.equals("%");						      
    }
    private static double apply(String op, double x, double y){
	if (op.equals("+")){
	    return x+y;
	}
	if (op.equals("-")){
	    return x-y;
	}
	if (op.equals("*")){
	    return x*y;
	}
	if(op.equals("/")){
	    return x/y;
	}
	if(op.equals("%")){
	    return x%y;
	}
	return 0;
    }
    public static void main(String[]a){
    }

}

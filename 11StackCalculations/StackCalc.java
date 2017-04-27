import java.util.*;
public class StackCalc{
    public static double eval(String x){
	String[] tokens = x.split(" ");
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
    private static boolean isOperator(String x){
	return x.equals("+")||x.equals("-")||x.equals("*")||x.equals("/")
	    ||x.equals("%");						      
    }
    private static double apply(String op, double x, double y){
	if (op.equals("+")){
	    return x+y;
	}
	if (op.equals("-")){
	    return y-x;
	}
	if (op.equals("*")){
	    return x*y;
	}
	if(op.equals("/")){
	    return y/x;
	}
	if(op.equals("%")){
	    return y%x;
	}
	return 0;
    }
    public static void main(String[]a){	
    System.out.println(StackCalc.eval("10 2 +"));//12.0
    System.out.println(StackCalc.eval("10 2 -"));//8.0
    System.out.println(StackCalc.eval("10 2.0 +"));//12.0
    System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
    System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//893.0
    System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }

}

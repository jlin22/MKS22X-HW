import java.util.*;
import java.io.*;
public class Quick{
    public static int part(int[]data, int start, int end){
	int x = (int)(Math.random()*(end - start +1)) + start;
	int pivot = data[x];
	int s = start;
	int e = end;
	int[] a = new int[data.length];
	for (int i = 0; i >= start && i <= end; i++){
	    if (i != x){
		if (data[i] < pivot){
		    a[s] = data[i];
		    s++;
		}
		if (data[i] > pivot){
		    a[e] = data[i];
		    e--;
		}
	    }
	}
	a[s] = pivot;
	data = a;
	for (int i = 0; i < a.length; i++){
	}
	return s;
    }
    public static int quickselect(int[]data,int k){
	int s = 0;
	int e = data.length - 1;
	while (e >= s){
	    int pivot = part(data, s, e);

	    if (k < pivot){
		e = pivot -1;
	    }
	    else if (k > pivot){
		s = pivot + 1;
	    }
	    else{
		return data[k];
	    }
	}
	return data[k];
    }
    public static void main(String[]a){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect(ary,3));
    }

}

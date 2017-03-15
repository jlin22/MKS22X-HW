import java.util.*;
import java.io.*;
public class Partition{
    public int part(int[]data, int start, int end){
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
	    System.out.println(a[i]);
	}
	return s;
    }
}

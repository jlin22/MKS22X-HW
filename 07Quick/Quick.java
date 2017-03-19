import java.util.*;
import java.io.*;
public class Quick{
    public static int part(int[]data, int start, int end){
	int x = (int)(Math.random()*(end - start +1)) + start;
	int pivot = data[x];
	int s = start;
	int e = end;
	while (s < e){
	    while (data[s] < pivot){
		s++;		
	    }
	    while(data[e] > pivot){
		e--;
	    }
	    if (s < e){
		swap(data,s,e);
		s++;
		e--;
	    }
	}
	return s;
    }
    public static void swap(int[]ary,int x, int y){
	int t = ary[x];
	ary[x] = ary[y];
	ary[y] = t;
    }
	
    public static int quickselect(int[]data,int k){
	int s = 0;
	int e = data.length - 1;
	while (s < e){
	    int p = part(data,s,e);
	    if (p == k){
		return data[k];
	    }
	    else if (p < k){
		s = p + 1;
	    }
	    else{
		e = p -1;
	    }

	}
	return data[k];
    }
    public static void quickSort(int[]ary){
	quickSortH(ary,0,ary.length-1);
    }
    public static void quickSortH(int[]ary,int s, int e){
	int p = part(ary,s,e);
	if (s < p - 1){
	    quickSortH(ary,s,p -1);
	}
	if (p < e){
	    quickSortH(ary,p,e);
	}
    }
    public static void main(String[]a){
	int[]ary = {0,99,10,25,16};
	//System.out.println(part(ary,0,2));
	System.out.println(quickselect(ary,3));
	//quickSort(ary);
	for (int i = 0; i < ary.length; i++){
	    System.out.print(ary[i]+",");
	}
    }

}

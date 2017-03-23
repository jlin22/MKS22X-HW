import java.util.*;
import java.io.*;
public class Quick{
    public static int part(int[]ary, int start, int end){
	//int pivot = ary[(start + end)/2];
	int pivot = ary[(int)(Math.random()*(end-start+1)+start)];
	int s = start;
	int e = end;
	while (s < e){
	    while (ary[s] < pivot){
		s++;		
	    }
	    while(ary[e] > pivot){
		e--;
	    }
	    if (s < e){
		swap(ary,s,e);
		if (ary[s] == ary[e]){
		    s++;
		}
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
    public static void quicksort(int[]ary){
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
    // public static void main(String[]a){
	//int[]ary = {2,10,15,23,0,5};
	//System.out.println(part(ary,0,4));
	//System.out.println(quickselect(ary,4));
	//quickSort(ary);
	//for (int i = 0; i < ary.length; i++){
	    //System.out.println(quickselect(ary,i));
	    // System.out.print(ary[i]+" ");
	//}
    

}

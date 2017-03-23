import java.util.*;
import java.io.*;
public class Quick{
    /*public static int part(int[]ary, int start, int end){
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
    }*/
    public static int[] part(int[]a,int lt,int gt){
	int v = a[(int)(Math.random()*(gt-lt+1)+lt)];
	int i = lt;
	while (i <= gt){
	    if (a[i] < v){
		swap(a,i,lt);
		i++;
		lt++;
	    }
	    else if(a[i] == v){
		i++;
	    }
	    else{
		swap(a,i,gt);
		gt--;
	    }
	}
	int[]x = new int[2];
	x[0] = lt;
	x[1] = gt;
	return x;
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
	    //int p = part(data,s,e);
	    int[] p = part(data,s,e);
	    /*if (p == k){
		return data[k];
	    }
	    else if (p < k){
		s = p + 1;
	    }
	    else{
		e = p -1;
		
	}
	    */
	    if (k > p[0] && k < p[1]){
		return data[k];
	    }
	    else if (p[1] < k){
		s = p[1]+1;
	    }
	    else{
		e = p[0]-1;
	    }
	}
	return data[k];

    }
       
	
	    

    public static void quicksort(int[]ary){
	quickSortH(ary,0,ary.length-1);
    }
    public static void quickSortH(int[]ary,int s, int e){
	//int p = part(ary,s,e);
	/*if (s < p - 1){
	    quickSortH(ary,s,p -1);
	}
	if (p < e){
	    quickSortH(ary,p,e);
	    }*/
	if (s < e){	    
	    int[] p = part(ary,s,e);
	    quickSortH(ary,s,p[0]-1);
	    quickSortH(ary,p[1]+1,e);
	}
	
    }
    // public static void main(String[]a){
	//int[]ary = {2,10,15,23,0,5};
	//ary = new int[10];
	//for (int i = 0; i < 10; i++){
	//  ary[i] = 0;
	//}
	//System.out.println(part(ary,0,4));
	//System.out.println(quickselect(ary,4));
	//quickSort(ary);
	//for (int i = 0; i < ary.length; i++){
	//System.out.println(quickselect(ary,i));
	    //System.out.print(ary[i]+" ");
	//}
    // }
    

}

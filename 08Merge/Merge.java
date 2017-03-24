public class Merge{
    //test on randomized min to max, randomized 0-10
    //all same value, sorted, reverse sorted for qsort and msort
    public static void mergesort(int[]ary){
	int[]left = new int[ary.length/2];
	for (int x = 0; x < ary.length/2; x++){
	    left[x] = ary[x];
	}
	int[]right = new int[ary.length-ary.length/2];
	if (ary.length != 1){
	    mergesort(left);
	    mergesort(right);
	}
	merge(left,right,ary);
    }
    public static void merge(int[]a,int[]b, int[] d){
	int x = 0;
	int y = 0;
	while (x < a.length && y< b.length){
	    if (a[x] >= b[y]){
		d[x+y] = b[y];
		y++;
	    } 
	    else{
		d[x+y] = a[x];
		x++;
	    }
	}
	if (x == a.length){
	    while (y < b.length){
		d[x+y] = b[y];
		y++;
	    }
	}
	else{
	    while (x < a.length){
		d[x+y] = a[x];
		x++;
	    }
	}
    }
    public static void main(String[]a){
	/*int[]y = {0,2,5,76,79};
	int[]x = {1,5,24,100,779};
	int[]z = new int[10];
	merge(x,y,z);
	for (int i = 0; i < z.length; i++){
	    System.out.print(z[i] + " ");
	    }*/
	int[]b = {6,1,276,125,17,2,56,7,12,6};
	mergesort(b);
	for (int i = 0; i < b.length; i++){
	    System.out.print(b[i] + " ");
	}
	    
    }
}
		      
			

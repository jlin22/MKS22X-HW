public class Merge{
    public static void mergesort(int[]ary){
	int[]left = new int[ary.length/2];
	int[]right = new int[ary.length-ary.length/2];
	mergesort(left);
	mergesort(right);
	merge(left,right,ary);
    }
    public static void merge(int[]a,int[]b, int[] d){
	int x = 0;
	int y = 0;
	if (x >= a.length){
	    while (y < b.length){
		d[x+y] = b[y];
		y++;
	    }
	}
	else if(y >= b.length){
	    while (x < a.length){
		d[x+y] = a[x];
	    }
	}
	else if (a[x] > b[y]){
	    d[x+y] = a[x];
	    x++;
	}
	else{
	    d[x+y] = b[y];
	    y++;
	}
    }
    public static void main(String[]a){
	int[]x = {0,2,5,76,79};
	int[]y = {1,5,24,100,779};
	int[]z = new int[10];
	merge(x,y,z);
	for (int i = 0; i < z.length; i++){
	    System.out.print(z[i] + " ");
	}
	   
    }
}
		      
			

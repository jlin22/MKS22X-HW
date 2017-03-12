import java.io.*;
import java.util.*;
public class USACO{
    int[]param;
    int[][]lake;
    int[][]com;
    int d;
    int[] i1;
    char[][] i2;
    int[] i3;
    int[][]x;
    public int bronze(String filename){
	d = 0;
        param = new int[4];
	try{
	Scanner inf = new Scanner(new File(filename));
	int ln = 1;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    if (ln == 1){
		for (int i = 0; i < 4; i++){
		    if (i < 3){
			param[i] = Integer.parseInt(line.substring(0,line.indexOf(" ")));
		    }
		    else{
			param[i] = Integer.parseInt(line);
		    }
		    if (i < 3){
		    line = line.substring(line.indexOf(" ") + 1);
		    }
		}
		com = new int[param[3]][3];
		lake = new int[param[0]][param[1]];
	    }
	    else if (ln >= 2 && ln <= param[0] + 1){
		for (int c = 0; c < param[1]; c++){
		    if (c < param[1] - 1){
			lake[ln-2][c] = Integer.parseInt(line.substring(0,line.indexOf(" ")));
		    }
		    else{
			lake[ln-2][c] = Integer.parseInt(line);
		    }
		    if (c < param[1] - 1){
			line = line.substring(line.indexOf(" ") + 1);
		    }
		}
		    
	    }
	    else if (ln >= param[0] + 2 && ln <= param[0] + param[3] + 1){


		for (int i = 0; i < 3; i++){
		    if (i < 2){
			com[ln-param[0]-2][i] = Integer.parseInt(line.substring(0,line.indexOf(" ")));
			line = line.substring(line.indexOf(" ") + 1);
		    }
		    else{
			com[ln-param[0]-2][i] = Integer.parseInt(line);
		    }
		}
	    }
	    ln++;
	}
	for (int i = 0; i < com.length;i++){
	    stomp(com[i][0],com[i][1],com[i][2]);
	}
	System.out.println(param[2]);
	for (int r = 0;r<lake.length;r++){
	    for (int c = 0;c<lake[r].length;c++){
		if (lake[r][c] < param[2]){
		    d += param[2] - lake[r][c];
		}
	    }
	}
	System.out.println(d);
	}catch(FileNotFoundException e){
	}
	return d * 72 * 72;
    }
    public void stomp(int r, int c, int d){
	int h = lake[r-1][c-1];
	for (int i = r - 1; i < r + 2 && i < lake.length && i >= r-1; i++){
	    for (int x = c - 1; x < c + 2 && x < lake[i].length&&x>=c-1; x++){
		if (lake[i][x] > h){
		    h = lake[i][x];
		    
		}
	    }
	}
	for (int t = 0; t < d; t++){
	    for (int i = r - 1; i < r + 2 && i < lake.length && i >= r-1; i++){
		for (int x = c - 1; x < c + 2 && x < lake[i].length&&x>=c-1; x++){
		    if (lake[i][x] == h){
			lake[i][x] = h - 1;
		    }
		}
	    }
	    h--;
	}
    }

    public int silver(String filename){
	i1 = new int[3];
	i3 = new int[4];
	try{	    
	Scanner inf = new Scanner(new File(filename));
	int ln = 1;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    System.out.println(line);
	    if (ln == 1){
		for (int i = 0; i < 3;i++){
		    if (i < 2){
			i1[i] = Integer.parseInt(line.substring(0,line.indexOf(" ")));
			line = line.substring(line.indexOf(" ") + 1);
		    }
		    else{
			i1[i] = Integer.parseInt(line);
		    }
		    
		}
		i2 = new char[i1[0]][i1[1]];
	    }
	    else if(ln >= 2 && ln <= i1[0] + 1){
		for (int c = 0; c < i1[1];c++){
		    i2[ln-2][c] = line.charAt(c);
		}
	    }
	    else if(ln == i1[0] + 2){
		for (int i = 0; i < 4;i++){
		    if (i < 3){
			i3[i] = Integer.parseInt(line.substring(0,line.indexOf(" ")));
			line = line.substring(line.indexOf(" ") + 1);
		    }
		    else{
			i3[i] = Integer.parseInt(line);
		    }
		    
		}
	    }
	    ln++;
	}
	travel(i3[0],i3[1],i1[2]);
 ;
	}catch(FileNotFoundException e){
	}
	return x[i3[2]-1][i3[3]-1];
    }
    public int[][] travel(int r, int c, int t){
	x = new int[i1[0]][i1[1]];
	for (int i = 0; i < x.length; i++){
	    for (int y = 0; y < x[i].length; y++){
		x[i][y] = 0;
	    }
	}
	x[r-1][c-1] = 1;
	for (int a = 0; a < t; a++){
	    int[][] z = new int[i1[0]][i1[1]];
	    for (int b = 0; b < i1[0]; b++){
		for (int e = 0; e < i1[1]; e++){
		    if (i2[b][e] == '.'){
			z[b][e] = value(b+1,e) + value(b-1,e) + value(b,e+1)+value(b,e-1);
		    }
		}
	    }
	    x = z;
	}
	return x;
    }
    public int value(int r, int c){
	if (r < 0 || r >= i1[0] || c < 0 || c >= i1[1]){
	    return 0;
	}
	else if (i2[r][c] == '*'){
	    return 0;
	}
	else{
	    return x[r][c];
	}
    }
	
    public static void main(String[]args){
	USACO x = new USACO();
	System.out.println(x.silver("test2.txt"));
    }
}

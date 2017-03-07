import java.util.*;
import java.io.*;
public class ReadFile{
    //private int[] variables;
    public int r, c, e, n;
    public int[][] lake;
    public int[][] stomp;//1-rs,2-cs,3-ds
    public ReadFile(String file){
	try{
	    File text = new File(file);
	    Scanner inf = new Scanner(text);
	    int lineNumber = 1;
	    lake = new int[r][c];
	    stomp = new int[n][3];
	    while (inf.hasNextLine()){
		String line = inf.nextLine();
		if (lineNumber == 1){
		    r = (int)line.charAt(0);
		    c = (int)line.charAt(2);
		    e = (int)line.charAt(4);
		    n = (int)line.charAt(6);
		}
		if (lineNumber >=2  && lineNumber <= r+1){
		    for (int i = 0; i < line.length(); i = i + 2){
			lake[lineNumber - 2][i/2] = (int)line.charAt(i);
		    }
		}
		if (lineNumber >=r +2  && lineNumber <=  r + n + 1){
		    for(int i = 0; i < line.length(); i = i +2){
			stomp[lineNumber - r - 2][i/2] = (int)line.charAt(i);
		    }
		}
		
		lineNumber++;
	    }
	}catch(FileNotFoundException e){
	}
    }
    public static void main(String[]a){
	ReadFile x = new ReadFile("infile1.txt");

    }
}
	

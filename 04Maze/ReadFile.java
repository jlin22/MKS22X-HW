import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
    private String filetext;
    private char[][] maze;
    public ReadFile(String file){
	filetext = "";	
	try{
	    File text = new File("data1.dat");
	    Scanner inf = new Scanner(text);
	    int lineNumber = 0;
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
	        filetext += line;
		lineNumber += 1;
	    }
	    maze = new char[lineNumber][filetext.length() / lineNumber];
	    for (int c = 0; c < lineNumber; c++){
		for (int i = 0; i < filetext.length() / lineNumber; i++){
		     maze[c][i] = filetext.charAt(c * filetext.length() / lineNumber + i);
		 }
	    }
	}catch (FileNotFoundException e){
	}
    }
    public char[][] getMaze(){
	return maze;
    }
    public String toString(){
	String a = "";
	for (int c = 0; c < maze.length; c++){
	    for (int r = 0; r < maze[c].length; r++){
	        a += maze[c][r];
		if (r == maze[c].length - 1){
		    a += "\n";
		}
	    }
	}
	return a;
    }
  public static void main(String args[]) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
      /* File text = new File("data1.dat");// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner(text);
        int lineNumber = 1;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            System.out.println(line);
      */
      ReadFile x = new ReadFile("data1.dat");
      System.out.println(x.toString());
      System.out.println(x.getMaze());
      
  }       
}   

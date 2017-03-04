import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
    public String read(String file){
	String x = "File not Found";
	try{
	    x = "";
	    File text = new File(file);
	    Scanner inf = new Scanner(text);
	    int lineNumber = 1;
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		x += inf.nextLine();
	    }
	}catch (FileNotFoundException e){
	    return "File not Found";
	}
	return "File not Found";
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
      ReadFile x = new ReadFile();
      System.out.println(x.read("data1.dat"));
        }       
    }   

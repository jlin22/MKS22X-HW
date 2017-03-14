import java.util.*;
public class Quiz2Redux{
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words,s,"",0);
	Collections.sort(words);
	return words;
    }
    private static void help(ArrayList<String>words, String s, String init,int i){
	if (i < s.length()){
	    if (i == 0){
		words.add(" ");
	    }
	    words.add(init + s.charAt(i));
	    help(words,s,init + s.charAt(i),i+1);
	    help(words,s,init,i+1);
	}
    }
    public static void main(String[]a){
	Quiz2Redux x = new Quiz2Redux();
	System.out.println(combinations("abc"));
    }
}

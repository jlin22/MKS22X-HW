import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{
    //works on data1-3, but in specific cases, ordering of the if statements makes it an infinite loop


    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

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
    public Maze(String filename){
	ReadFile x = new ReadFile(filename);
	maze = x.getMaze();
	if (!x.mazeGood()){
	    throw new Error("Invalid Maze");
	}
	
    }
       private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e){
         }
     }
		    				

    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;

            //Initialize starting row and startint col with the location of the S. 
	    for (int c = 0; c < maze.length; c++){
		for (int r = 0 ; r < maze[c].length; r++){
		    if (maze[c][r] == 'S'){
			startr = c;
			startc = r;
		    }
		}
	    }		
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }

        //COMPLETE SOLVE
	if (maze[row][col] == 'E'){
	    return true;
	}
	if (maze[row][col] == '#' || maze[row][col] == '@'){
	    return false;
	}
	maze[row][col]='@';
	if (solve(row+1,col)){
	    return true;
	}
	if (solve(row,col-1)){
	    return true;
	}	    	    
	
	if (solve(row-1,col)){
	    return true;
	}	    
	
	if (solve(row,col+1)){
	    return true;
	}	    
	
	maze[row][col]='.';
        return false; //so it compiles
    }


}

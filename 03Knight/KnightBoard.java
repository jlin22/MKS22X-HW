public class KnightBoard{
    private int[][]board;
    //make a board for used squares
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }
    public String toString(){
	String a = new String("");
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[r].length; c++){
		if (board[r][c] < 10){
		    a += "0" + board[r][c] + " ";
		}
		else{
		    a += board[r][c] + " ";
		}
		if (c == board[r].length - 1){
		    a+= "\n";
		}
	    }
	}
	return a;
    }
    public void solve(){
         solveH(0,0,1);
    }
    public boolean solveH(int row, int col, int level){
	if (board.length * board[row].length == level){
	    return true;
	}
	int[] x = {2, 1, -1, -2, -2, -1, 1, 2};
	int[] y = {1, 2, 2, 1, -1, -2, -2, -1};
	for (int i = 0; i < 8; i++){
	    if (row + x[i] < board.length
		&& row + x[i] > -1
		&& col + y[i] < board[0].length
		&&col + y[i] > -1
		&& board[row + x[i]][col + y[i]] == 0){
		board[row+x[i]][col+y[i]] = level + 1;
		if( solveH(row + x[i], col + y[i], level + 1)){
		    return true;
		}
		else{
		    board[row+x[i]][col+y[i]] = 0;
		}
	    }
	}		    		       	
	return false;
	}
    public static void main(String[]a){
	KnightBoard x = new KnightBoard(6,8);
	x.solve();
	System.out.println(x.toString());
    }
}

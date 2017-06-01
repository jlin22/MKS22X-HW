import java.util.*;
public class MazeSolver{
    private Maze m;
    private boolean animate;
    private Location s, e;
    public MazeSolver(String filename){
	this(filename,false);	
    }
    public MazeSolver(String filename, boolean anim){
	m = new Maze(filename);
	animate = anim;
	s = m.getStart();
	e = m.getEnd();
    }
    public void solve(){
	solve(1);
    }
    public void solve(int x){
	Frontier a;
	if (x==0){
	    a = new StackFrontier();
	}
	else if (x==2||x==3){	    
	    a= new FrontierPriorityQueue();		
	}
	else{
	    a = new QueueFrontier();
	}
	a.add(s);
	boolean b = false;
	if (x ==3){
	    b = true;
	}
	while (a.size() != 0){
	    Location l = a.next();
	    if (l.getDTG()==0){
	        m.set(s.getRow(),s.getCol(),'@');
		while (l.getDTS()!=0){
		    m.set(l.getRow(), l.getCol(),'@');
		    l = l.getPrev();
		}
		m.set(s.getRow(),s.getCol(),'S');
		m.set(e.getRow(),e.getCol(),'E');
		System.out.println(toString());
		return;
	    }
	    m.set(l.getRow(),l.getCol(),'.');
	    if (m.get(l.getRow()+1,l.getCol())==' '){
		a.add(new Location(l.getRow()+1,l.getCol(),l,Math.abs(l.getRow()+1-s.getRow())+Math.abs(l.getCol()-s.getCol()),Math.abs(l.getRow()+1-e.getRow())+Math.abs(l.getCol()-e.getCol()),b));
		m.set(l.getRow()+1,l.getCol(),'?');
	    }
	    if (m.get(l.getRow()-1,l.getCol())==' '){
		a.add(new Location(l.getRow()-1,l.getCol(),l,Math.abs(l.getRow()-1-s.getRow())+Math.abs(l.getCol()-s.getCol()),Math.abs(l.getRow()-1-e.getRow())+Math.abs(l.getCol()-e.getCol()),b));
		m.set(l.getRow()-1,l.getCol(),'?');
	    }
	    if (m.get(l.getRow(),l.getCol()+1)==' '){
		a.add(new Location(l.getRow(),l.getCol()+1,l,Math.abs(l.getRow()-s.getRow())+Math.abs(l.getCol()+1-s.getCol()),Math.abs(l.getRow()-e.getRow())+Math.abs(l.getCol()+1-e.getCol()),b));
		m.set(l.getRow(),l.getCol()+1,'?');
	    }
	    if (m.get(l.getRow(),l.getCol()-1)==' '){
		a.add(new Location(l.getRow(),l.getCol()-1,l,Math.abs(l.getRow()-s.getRow())+Math.abs(l.getCol()-1-s.getCol()),Math.abs(l.getRow()-e.getRow())+Math.abs(l.getCol()-1-e.getCol()),b));
		m.set(l.getRow(),l.getCol()-1,'?');
	    }
	    System.out.println(toString());
	}			     					  
    }
    public String toString(){
	return m.toString();
    }
    /* public static void main(String[]a){
	MazeSolver x = new MazeSolver("data1.dat");
	x.solve(1);
    }*/
    
}

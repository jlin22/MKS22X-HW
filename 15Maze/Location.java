public class Location implements Comparable<Location>{
    private int row;
    private int col;
    private Location previous;
    private int dts;
    private int dtg;
    private boolean aStar;
    public Location(int r, int c, Location prev, int DS, int DG){
	row = r;
	col = c;
	previous = prev;
	dts = DS;
	dtg = DG;
	aStar = true;
    }
    public Location(int r, int c, Location prev, int DS, int DG, boolean a){
	row = r;
	col = c;
	previous = prev;
	dts = DS;
	dtg = DG;
	aStar = true;
	if(!a){
	    aStar = false;
	}
    }
    public int getDTS(){
	return dts;
    }
    public int getDTG(){
	return dtg;
    } 
    public Location getPrev(){
	return previous;
    }
    public int compareTo(Location other){
	if(aStar){
	    return dts+dtg-other.getDTS()-other.getDTG();
	}
	else{
	    return dtg-other.getDTG();
	}
	
    }
    /*public static void main(String[]a){
	Location x = new Location(0,0,null,0,5,false);
	Location y = new Location(1,1,x,4,0,false);
	System.out.println(x.compareTo(y));
    }*/
}

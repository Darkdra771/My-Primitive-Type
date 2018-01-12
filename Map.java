
public class Map{

	private Pair obj = null;
	private Map next = null;
	private MapIterator iter = null; //iterator for the map
	private Map endPoint = null; //points to the dummy pointer
	private int length = 0; //length of map

	public Map(){} //constructor
	public Map(Pair val){ obj = val;} //constructor

	//create iterator and return the beginning 
	public MapIterator begin(){
		if (iter != null){ return new MapIterator(this);} 
		iter = new MapIterator(this); 
		iter.setEndPoints(this); 
		return iter;}

	//return the dummy pointer
	public MapIterator end(){ return iter.end();}

	public MapIterator find(MyChar key){ //find pair 
		
		MapIterator temp = new MapIterator(this);

		while( !temp.equal(end())){ //search for the right key
			if( (temp.get()).getKey() == key.Get() ){  
				return temp;
			}
			temp.advance();
		} 

		return temp;
	}
	
	public Pair Get(){ return obj;} //return the pair

	public void add(Pair val){ //add pair into map

		if (obj == null){ obj = val; return;} //if empty map
		
		if ((val.getKey()) >= obj.getKey()){ //if key is equal or more 
			if (next == null){
				Map temp = new Map();
				next = temp;
			}
			next.add(val);
		}
		else { //if key is less
			if( next == null){
				Map temp = new Map(obj);
				this.next = temp;
				obj = val;
			}
			else{
				Map temp = new Map(obj);
				temp.setNext(this.next);
				obj = val;
				next = temp;
			}
		}
		length++;
	}

	public void Print(){ //prints the map

		System.out.print("[ ");
		if ( obj != null){ obj.Print(); } //if there is a pair
		System.out.print(" ");
		if ( next != null){ next.printMap(); } //prints map
		System.out.print("]");
		return;
	}

	
	public void printMap(){ //recursion for printing map

		if( obj != null){ obj.Print();}
		System.out.print(" ");
		if ( next != null && next != endPoint){ next.printMap();} //take care of this

	}

	public Map addAndReturnDummy(){ //add dummy pointer at the end and return it for iteration
		if( next == null){ 
			Pair temp = new Pair(new MyChar('~'), new MyInteger(-1));
			Map dummy = new Map(temp);
			next = dummy;
			endPoint = dummy;
			return dummy;
		}
		else{
			return next.addAndReturnDummy();
		}
		
		
	}	

	public Map returnNext(){ return next;}
	public void setNext(Map val) { next = val;}




}

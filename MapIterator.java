

public class MapIterator{

  private Map points = null; //points to the map
  private Pair obj = null; //stores the value of the map
  private MapIterator endPoints = null; //the pointer to the end

  public MapIterator(Map val){ obj = val.Get(); points = val;} //constructor
  public void setEndPoints(Map val){ //create a dummy and points to it at the end
    endPoints = new MapIterator(val.addAndReturnDummy());
  }
  public Map pointing(){ return points;} //pointing to what
  public MapIterator end(){ return endPoints;}
  public void advance(){ points = points.returnNext(); obj = points.Get();} //advance pointer
  public Pair get(){ //return the pair
     if (obj == null){ return null;}
     return obj;}
  public boolean equal(MapIterator val){ //compare with end pointer
	return val.pointing() == this.pointing();}

}

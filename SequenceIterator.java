
class SequenceIterator{

  private Element points = null; //stores the value of the sequence
  private Sequence obj = null; //points to the sequence
  private SequenceIterator endPoints = null; //the pointer to the end 

  public SequenceIterator(Sequence val){ obj = val; points = val.Get();} //constructor
  public void setEndPoints(Sequence val){ //create a dummy and points to it at the end
    endPoints = new SequenceIterator(val.addAndReturnDummy());
  }
  public Element pointing(){ return points;} //pointing to what 
  public SequenceIterator end(){ return endPoints;}
  public void advance(){ obj = obj.GetNext(); points = obj.Get();} //advance pointer
  public Element get(){ //return sequence
     if (points == null){ return null;}
     return points;}
  //compare with end pointer
  public boolean equal(SequenceIterator val){return this.pointing() == val.pointing();}



}

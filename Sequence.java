

public class Sequence extends Element<Element> {

  private Element value = null;
  private Sequence next = null;
  private int length = 0;
  private static Sequence FlatSequence = null; //to store flatten sequence
  private SequenceIterator iter = null; //for iterator

  //make iterator and return it
  public SequenceIterator begin(){ iter = new SequenceIterator(this); iter.setEndPoints(this); return iter;}

  //returns the dummy pointer at the end
  public SequenceIterator end(){ return iter.end();}

  public Sequence(){ //constructor
    value = null;
    next = null;
  }

  public Sequence(Element val){ value = val;} //constructor

  public void Print(){ //prints the sequence
    System.out.print("[");
    if(value != null){
      System.out.print(" ");
      value.Print();
    }
    if (next != null){
      System.out.print(" ");
      next.PrintValue();
    }
    System.out.print(" ]");
  }

  public void PrintValue(){ //recursion for print
    if (value != null){
      value.Print();
    }
    if (next != null && length > 1){
      System.out.print(" ");
      next.PrintValue();
    }
  }

  public Element first(){ //return the first element of the sequence
    return value;
  }

  public Sequence rest(){ // returns the rest of the elements of the Sequence
    return next;
  }

  public void add(Element elm, int pos){ //add elements tot the position
    if (pos < 0 || pos > length){ System.err.println("Adding Element outside of the length of Sequence!");} //check error statement
    if (pos == 0){
      if (value != null){ //if there is already a value
        Sequence newSequence = new Sequence();
        newSequence.Set(value);
        newSequence.SetNext(next);
	newSequence.setLength(length);
        SetNext(newSequence);
      }
      Set(elm);
    }
    else{
      if ( next == null){ next = new Sequence();}
      next.add(elm, pos - 1);}
    length++;
  }

  public void delete(int pos){ //deletes element at position
    if( pos < 0 || pos >= length){ return;}
    if (pos == 0){
      if (next != null){
        value = next.Get();
        next = next.GetNext();
      }
      else if (value == null){/*do nothing*/}
    }
    else{
      next.delete(pos - 1);
    }
    deleteNext();
    length--;
  }

  public Element index(int pos){//return element at position
    if (pos < 0 || pos >= length){ System.err.println("Accessing index " + pos + " is out of bounds of length: " + length + "."); System.exit(1);} 
    if ( pos == 0){ return value;}
    else {
      return next.index(pos - 1);
    }
  }


  public Sequence flatten(){ //to flatten a sequence
    FlatSequence = new Sequence();
    fillSequence(value);
    return FlatSequence;
  }

  public void fill(){ 
    fillSequence(value);
  }

  public void fillSequence(Element elm){ //fill the new sequence using recursion
    if( elm.Id() == "integer" || elm.Id() == "char"){ //check type of element 
      FlatSequence.lastAdd(elm);
      if (next != null){
        next.fill();
      }
      else {
        return;
      }
    }
    else if( elm.Id() == "Sequence"){ //if it is sequence
      ((Sequence)elm).fillSequence((Element)elm.GetElement());
      if( next != null){
        next.fillSequence(next.GetElement());
      }
    }
  }

  public Sequence copy(){ //create a deep copy of the sequence
    Sequence copySequence = new Sequence();
    fillCopy(copySequence);
    return copySequence;
  }

  public void fillCopy(Sequence copySequence){ //fill the copy using recursion

    if (value.Id() == "integer"){ //check type of element
      MyInteger temp = new MyInteger(((MyInteger)value).GetElement());
      copySequence.lastAdd(temp);
    }
    else if(value.Id() == "char"){
      MyChar temp = new MyChar(((MyChar)value).GetElement());
      copySequence.lastAdd(temp);
    }
    else{
      Sequence temp = new Sequence();
      ((Sequence)value).fillCopy(temp);
      copySequence.lastAdd(temp);
    }

    if (next != null){ next.fillCopy(copySequence);}
    else {
      return;
    }
  }

  public Sequence addAndReturnDummy(){ //make a dummy element at the end for iteration
    (returnThis(length - 1)).SetNext(new Sequence(new MyInteger(-1)));
    return returnThis(length); }

  public Sequence returnThis(int pos){ //return a pointer to the current sequence
    if( pos == 0){ return this;}
    else{
      return next.returnThis(pos - 1);
    }
  }

  public void lastAdd(Element val){ add(val, length);} //add element to the back
  public void setLength(int val) { length = val;} //set the length
  public String Id(){ return "Sequence";}
  public Element Get(){ return value;}
  public Element GetElement(){ return value;}
  public int length(){ return length;} //returns length of Sequence
  public void Set(Element val){ value = val;}
  public void SetNext(Sequence val){ next = val;}
  public Sequence GetNext(){ return next;}
  public void deleteNext(){ //if next is null delete it
    if(next == null){ return;}
    if (next.Get() == null){
      next = null;
    }
  }

}

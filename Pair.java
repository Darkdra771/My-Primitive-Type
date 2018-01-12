
public class Pair{

  private MyChar key = null;
  private Element obj = null;

  public Pair(){} //constructor
  public Pair(MyChar val, Element elm){ key = val; obj = elm;} //constructor

  public char getKey(){return key.Get();} //return key
  public Element getObj(){ return obj;} //return object
  public void Print(){ //prints the pair
	System.out.print("('" + key.Get() + "' "); 
	obj.Print();
	System.out.print(")");
  }

}

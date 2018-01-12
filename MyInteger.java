
public class MyInteger extends Element<MyInteger> {

  private int value = 0;

  public MyInteger(){} //constructor
  public MyInteger(int val){ value = val;} //constructor
  public MyInteger(MyInteger val){ value = val.Get();} //constructor
  public int Get(){ return value;} //return value
  public MyInteger GetElement() { return this;} //returns element
  public void Set(int val){ value = val;} //change value
  public void Print(){ System.out.print(value);} //prints element
  public String Id(){ return "integer";}

}



public class MyChar extends Element<MyChar> {

  private char value = '0';

  public MyChar(){} //constructor
  public MyChar(char val){ value = val;} //constructor
  public MyChar(MyChar val){ value = val.Get();} //constructor
  public char Get(){return value;} //return value
  public MyChar GetElement() { return this;} //returns element
  public void Set(char val){ value = val;} //change value
  public void Print(){ System.out.print("'" + value + "'");} //prints element
  public String Id(){ return "char";}

}

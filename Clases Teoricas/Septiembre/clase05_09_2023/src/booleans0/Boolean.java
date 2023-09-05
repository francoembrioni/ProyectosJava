package booleans0;

public class Boolean {
  public boolean value;
  
  public Boolean( boolean b ) {
    value = b;
  }
  
  static Boolean True() {
    return new BTrue();
  }

  static Boolean False() {
    return new DFalse();
  }

  public boolean equals( Object other ) {
    return other.getClass() == getClass() && value == ((Boolean)other).value;
  }

public abstract Boolean yy (Boolean v);
  
  public Boolean oo( Boolean v ) {
    if ( value ) {
      return True();
    } else {
      return v;
    }  
  }
  public Boolean not() {
    if ( value ) {
      return False();
    } else {
      return True();
    }
  }

public Object yy(Boolean true1) {
	// TODO Auto-generated method stub
	return null;
}
  
}

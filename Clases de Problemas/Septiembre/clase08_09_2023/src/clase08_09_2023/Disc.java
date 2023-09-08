package clase08_09_2023;

public class Disc {
	private int radio;
	
	public Disc(int radio) {
		this.radio = radio;
	}
	
	public int getRadio() {
		return radio;
	}

	public boolean stacksOn(Disc disc) {
//		if(this.radio < disc.radio) {
//			return true;
//		}
//		return false;
		return radio < disc.radio;
	}
}

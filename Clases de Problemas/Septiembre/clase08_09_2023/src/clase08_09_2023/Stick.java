package clase08_09_2023;

import java.util.ArrayList;

public class Stick {
	private ArrayList<Disc> discs = new ArrayList();
	public Stick push(Disc newTop) {
		//Debe estar vacio el stick o tener un disco mayor
		if(discs.isEmpty() || newTop.stacksOn(top())) {
			discs.add(newTop);
		}
		else {
			throw new RuntimeException("Forbidden move");
		}
		return this ;
	}

	public Disc top() {
		
		return discs.get(discs.size()-1);
	}

	public Object pop() {
		
		return discs.remove(discs.size()-1);
	}
}

package clase08_09_2023;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class HanoiTest {
@Test
public void test01AddElementToNewStick() {
	Disc aDisc = new Disc(2);
//	Stick aStick = new Stick();
//	aStick.push(aDisc);
	assertEquals (aDisc,new Stick().push(aDisc).top());
}

	@Test
	public void test02AddASecondElement() {
		Disc bigDisc = new Disc(3);
		Disc smallDisc = new Disc(2);
		Stick aStick = new Stick().push(bigDisc);
		aStick.push(smallDisc);
		
		assertEquals(smallDisc, aStick.pop());
		assertEquals(bigDisc,aStick.top());
		
	}
	@Test
	public void test03FailWhenAddingABiggerElement() {
		Disc bigDisc = new Disc(3);
		Disc smallDisc = new Disc(2);
		Stick aStick = new Stick().push(smallDisc);
		try {
			aStick.push(bigDisc);
			fail("This should fail");
		}
		catch(Exception e) {
			assertEquals("Forbidden move",e.getMessage());
		}
		
	}
	@Test
	public void test04ASmallDiscStacksOverABigDisc() {
		assertTrue(new Disc(3).stacksOn(new Disc(4)));
	}
	@Test
	public void test05ABigDiscDoesNotStacksOverASmallDisc() {
		assertFalse(new Disc(4).stacksOn(new Disc(3)));
	}
	@Test
	public void test06 () {
		Stick stickRight = new Stick();
		stickRight.push(new Disc(3));
		Hanoi hanoi = new Hanoi(new Stick(),new Stick(),stickRight);
		hanoi.moveRL();
		
		assertEquals(new Disc(3),hanoi.left().top());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

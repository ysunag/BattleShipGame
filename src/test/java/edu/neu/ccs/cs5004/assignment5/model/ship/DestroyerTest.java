package edu.neu.ccs.cs5004.assignment5.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DestroyerTest {
  private Destroyer testDestroyer;
  private Destroyer sameRefDestroyer;
  private Destroyer sameStateDestroyer;


  @Before
  public void setUp() throws Exception {
    testDestroyer = new Destroyer(0);
    sameStateDestroyer = new Destroyer(0);
    sameRefDestroyer = testDestroyer;
  }



  @Test
  public void testToString() {
    Assert.assertEquals("Destroyer{size=1, numberOfHitCells=0}",
            testDestroyer.toString());
  }

  @Test
  public void equals() {
    Destroyer diffDestroyer = new Destroyer(1);
    Destroyer anotherDestroyer = new Destroyer(0);
    Destroyer nullDestroyer = null;


    Assert.assertTrue(testDestroyer.equals(testDestroyer));
    Assert.assertTrue(testDestroyer.equals(sameRefDestroyer));
    Assert.assertTrue(testDestroyer.equals(sameStateDestroyer));
    Assert.assertEquals(testDestroyer.equals(sameStateDestroyer),
            sameStateDestroyer.equals(testDestroyer));
    Assert.assertEquals(testDestroyer.equals(sameStateDestroyer) &&
            sameStateDestroyer.equals(anotherDestroyer), testDestroyer.equals(anotherDestroyer));
    Assert.assertFalse(testDestroyer.equals(diffDestroyer));
    Assert.assertFalse(testDestroyer.equals(nullDestroyer));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testDestroyer.equals(sameRefDestroyer),
            testDestroyer.hashCode() == sameRefDestroyer.hashCode());
    Assert.assertEquals(testDestroyer.equals(sameStateDestroyer),
            testDestroyer.hashCode() == sameStateDestroyer.hashCode());
  }
}
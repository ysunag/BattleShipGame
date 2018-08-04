package edu.neu.ccs.cs5004.assignment5.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AttackableTest {
  private Attackable attackHit;
  private Attackable attackSunk;
  private Attackable attackMiss;

  @Before
  public void setUp() throws Exception {
    attackHit = new Hit();
    attackSunk = new Sunk();
    attackMiss = new Miss();
  }

  @Test
  public void attackResult() {
    Assert.assertEquals("Hit!", attackHit.attackResult());
    Assert.assertEquals("Miss!", attackMiss.attackResult());
    Assert.assertEquals("Sunk!", attackSunk.attackResult());
  }
}
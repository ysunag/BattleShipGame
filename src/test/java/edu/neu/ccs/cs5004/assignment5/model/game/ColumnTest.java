package edu.neu.ccs.cs5004.assignment5.model.game;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnTest {


  @Test
  public void getCol() {
    Assert.assertEquals(0, Column.A.getCol());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Column{col=0}", Column.A.toString());
  }


  @Test
  public void next() {
    Assert.assertEquals(null, Column.J.next());
    Assert.assertEquals(Column.B, Column.A.next());
  }

  @Test
  public void find() {
    Assert.assertEquals(Column.C, Column.find(2));
    Assert.assertEquals(Column.D, Column.find(3));
  }

}
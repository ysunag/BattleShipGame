package edu.neu.ccs.cs5004.assignment5.model.cell;

import edu.neu.ccs.cs5004.assignment5.view.DebugConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.view.Printer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractWaterCellTest {
  private AbstractWaterCell testGapCell;


  @Before
  public void setUp() throws Exception {
    testGapCell = new GapCell(false);
  }

  @Test
  public void attackResult() {
    Assert.assertEquals(new Miss(), testGapCell.attackResult());
  }

  @Test
  public void attackCell() {
    testGapCell.attackCell();
    Assert.assertEquals(new GapCell(true), testGapCell);
  }

  @Test
  public void prettyPrint() {
    Printer printer = new DebugConsolePrinter();
    testGapCell.prettyPrint(printer);
  }

  @Test
  public void getShipUpdate() {
    Assert.assertEquals(null, testGapCell.getShipUpdate());
  }
}
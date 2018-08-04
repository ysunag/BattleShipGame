package edu.neu.ccs.cs5004.assignment5.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;


public class ReadConsoleTest {

  String mockInput;
  private ReadConsole reader;

  private ReadConsole sameRefReader;
  private ReadConsole sameStateReader;

  @Before
  public void setUp() throws Exception {
    mockInput = "battleship";
    reader = new ReadConsole();

    sameStateReader = new ReadConsole();
    sameRefReader = reader;
  }

  @Test
  public void toRead() throws UnsupportedEncodingException {
    InputStream mockInputStream = new ByteArrayInputStream(mockInput.getBytes("UTF-8"));
    Assert.assertEquals(mockInput, reader.toRead(mockInputStream));
  }

  @Test
  public void equals() {
    ReadConsole nullReadConsole = null;
    ReadConsole anotherReadConsole = new ReadConsole();

    Assert.assertTrue(reader.equals(reader));
    Assert.assertTrue(reader.equals(sameRefReader));
    Assert.assertTrue(reader.equals(sameStateReader));
    Assert.assertEquals(reader.equals(sameStateReader), sameStateReader.equals(reader));
    Assert.assertEquals(reader.equals(sameStateReader) &&
            sameStateReader.equals(anotherReadConsole), reader.equals(anotherReadConsole));
    Assert.assertFalse(reader.equals(nullReadConsole));
    Assert.assertFalse(reader.equals(new Integer(0)));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(reader.equals(sameRefReader),
            reader.hashCode() == sameRefReader.hashCode());
    Assert.assertEquals(reader.equals(sameStateReader),
            reader.hashCode() == sameStateReader.hashCode());
  }

  }
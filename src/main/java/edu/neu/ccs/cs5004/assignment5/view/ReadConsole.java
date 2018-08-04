package edu.neu.ccs.cs5004.assignment5.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadConsole {
  /**
   * Read the input information.
   * @param stream the input information.
   * @return a string which content is the input.
   */
  public static String toRead(InputStream stream) {
    String input = null;
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));

      input = reader.readLine();

    } catch (IOException e) {
      e.printStackTrace();
    }
    return input;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {

    return 107;
  }
}


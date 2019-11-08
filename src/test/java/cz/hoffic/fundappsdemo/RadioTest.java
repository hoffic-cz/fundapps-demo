package cz.hoffic.fundappsdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RadioTest {

  @Test
  public void empty() {
    var radio = new Radio();

    assertEquals("", radio.receive());
  }

  @Test
  public void radio() {
    var radio = new Radio();

    radio.send("Hi FundApps!");
    radio.send("It's the rover'");

    assertEquals("Hi FundApps!\nIt's the rover'", radio.receive());
  }
}

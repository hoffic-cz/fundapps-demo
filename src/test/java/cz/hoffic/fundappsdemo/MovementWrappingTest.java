package cz.hoffic.fundappsdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovementWrappingTest {

  @Test
  public void yWrap() {
    var navigation = new Navigation(5);

    navigation.command("FFFF");

    assertEquals(4, navigation.getY());

    navigation.command("F");

    assertEquals(0, navigation.getY());
  }

  @Test
  public void xWrap() {
    var navigation = new Navigation(5);

    navigation.command("L");

    navigation.command("F");

    assertEquals(4, navigation.getX());
  }

  @Test
  public void xAndYWrap() {
    var navigation = new Navigation(5);

    navigation.command("LFLF");

    assertEquals(4, navigation.getX());
    assertEquals(4, navigation.getY());
  }
}

package cz.hoffic.fundappsdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MovementTest {

  @Test
  public void initialState() {
    var navigation = new Navigation();

    assertEquals(0, navigation.getX());
    assertEquals(0, navigation.getY());
    assertEquals('N', navigation.getHeading());
  }

  @Test
  public void forwardAndBackwards() {
    var navigation = new Navigation();

    navigation.command("F");

    assertEquals(0, navigation.getX());
    assertEquals(1, navigation.getY());
    assertEquals('N', navigation.getHeading());

    navigation.command("B");

    assertEquals(0, navigation.getX());
    assertEquals(0, navigation.getY());
    assertEquals('N', navigation.getHeading());
  }

  @Test
  public void multipleForwardAndBackwards() {
    var navigation = new Navigation();

    navigation.command("FF");

    assertEquals(0, navigation.getX());
    assertEquals(2, navigation.getY());
    assertEquals('N', navigation.getHeading());

    navigation.command("BB");

    assertEquals(0, navigation.getX());
    assertEquals(0, navigation.getY());
    assertEquals('N', navigation.getHeading());
  }

  /**
   * Updated to allow for wrapping around.
   */
  @Test
  public void backFirstThenForward() {
    var navigation = new Navigation(5);

    navigation.command("B");

    assertEquals(0, navigation.getX());
    assertEquals(4, navigation.getY());
    assertEquals('N', navigation.getHeading());

    navigation.command("F");

    assertEquals(0, navigation.getX());
    assertEquals(0, navigation.getY());
    assertEquals('N', navigation.getHeading());
  }
}

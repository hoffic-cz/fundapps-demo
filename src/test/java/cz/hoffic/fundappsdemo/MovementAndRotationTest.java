package cz.hoffic.fundappsdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovementAndRotationTest {

  @Test
  public void initialState() {
    var navigation = new Navigation();

    assertEquals(0, navigation.getX());
    assertEquals(0, navigation.getY());
    assertEquals('N', navigation.getHeading());
  }

  @Test
  public void forwardRightForward() {
    var navigation = new Navigation();

    navigation.command("FRF");

    assertEquals(1, navigation.getX());
    assertEquals(1, navigation.getY());
    assertEquals('E', navigation.getHeading());
  }

  /**
   * Updated to allow for wrapping around.
   */
  @Test
  public void forwardLeftForward() {
    var navigation = new Navigation(5);

    navigation.command("FLF");

    assertEquals(4, navigation.getX());
    assertEquals(1, navigation.getY());
    assertEquals('W', navigation.getHeading());
  }

  /**
   * Updated to allow for wrapping around.
   */
  @Test
  public void reverseTurningRight() {
    var navigation = new Navigation(5);

    navigation.command("BRB");

    assertEquals(4, navigation.getX());
    assertEquals(4, navigation.getY());
    assertEquals('E', navigation.getHeading());
  }

  /**
   * Updated to allow for wrapping around.
   */
  @Test
  public void reverseTurningLeft() {
    var navigation = new Navigation(5);

    navigation.command("BLB");

    assertEquals(1, navigation.getX());
    assertEquals(4, navigation.getY());
    assertEquals('W', navigation.getHeading());
  }
}

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

  @Test
  public void forwardLeftForward() {
    var navigation = new Navigation();

    navigation.command("FLF");

    assertEquals(-1, navigation.getX());
    assertEquals(1, navigation.getY());
    assertEquals('W', navigation.getHeading());
  }

  @Test
  public void reverseTurningRight() {
    var navigation = new Navigation();

    navigation.command("BRB");

    assertEquals(-1, navigation.getX());
    assertEquals(-1, navigation.getY());
    assertEquals('E', navigation.getHeading());
  }

  @Test
  public void reverseTurningLeft() {
    var navigation = new Navigation();

    navigation.command("BLB");

    assertEquals(1, navigation.getX());
    assertEquals(-1, navigation.getY());
    assertEquals('W', navigation.getHeading());
  }
}

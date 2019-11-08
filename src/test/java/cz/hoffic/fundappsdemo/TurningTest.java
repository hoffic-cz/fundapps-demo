package cz.hoffic.fundappsdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TurningTest {

  @Test
  public void turnRight() {
    var navigation = new Navigation();

    assertEquals('N', navigation.getHeading());

    navigation.command("R");

    assertEquals('E', navigation.getHeading());
  }

  @Test
  public void turnLeft() {
    var navigation = new Navigation();

    assertEquals('N', navigation.getHeading());

    navigation.command("L");

    assertEquals('W', navigation.getHeading());
  }

  @Test
  public void turningBackAndForth() {
    var navigation = new Navigation();

    assertEquals('N', navigation.getHeading());

    navigation.command("LR");

    assertEquals('N', navigation.getHeading());

    navigation.command("RL");

    assertEquals('N', navigation.getHeading());
  }

  @Test
  public void turningTwice() {
    var navigation = new Navigation();

    assertEquals('N', navigation.getHeading());

    navigation.command("LL");

    assertEquals('S', navigation.getHeading());

    navigation.command("RR");

    assertEquals('N', navigation.getHeading());
  }

  @Test
  public void turningAround() {
    var navigation = new Navigation();

    assertEquals('N', navigation.getHeading());

    navigation.command("RRRR");

    assertEquals('N', navigation.getHeading());

    navigation.command("LLLL");

    assertEquals('N', navigation.getHeading());
  }

  @Test
  public void movementHasNoEffect() {
    var navigation = new Navigation();

    assertEquals('N', navigation.getHeading());

    navigation.command("FFBF");

    assertEquals('N', navigation.getHeading());
  }

  @Test
  public void turningEachDirection() {
    var navigation = new Navigation();

    assertEquals('N', navigation.getHeading());

    navigation.command("R");

    assertEquals('E', navigation.getHeading());

    navigation.command("R");

    assertEquals('S', navigation.getHeading());

    navigation.command("R");

    assertEquals('W', navigation.getHeading());

    navigation.command("R");

    assertEquals('N', navigation.getHeading());
  }
}

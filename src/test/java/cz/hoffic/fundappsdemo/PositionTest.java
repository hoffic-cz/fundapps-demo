package cz.hoffic.fundappsdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PositionTest {

  @Test
  public void basicConstruction() {
    var position = new Position(0, 0);

    assertEquals(0, position.getX());
    assertEquals(0, position.getY());
  }

  @Test
  public void customConstruction() {
    var position = new Position(2, 5);

    assertEquals(2, position.getX());
    assertEquals(5, position.getY());
  }
}

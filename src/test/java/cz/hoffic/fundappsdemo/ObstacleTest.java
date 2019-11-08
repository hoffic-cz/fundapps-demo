package cz.hoffic.fundappsdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ObstacleTest {

  @Test
  public void obstacleEncountered() {
    var navigation = new Navigation();
    var obstacle = new Position(0, 1);
    var radio = new Radio();

    navigation.addObstacle(obstacle);
    navigation.setRadio(radio);

    navigation.command("F");

    assertEquals(0, navigation.getX());
    assertEquals(0, navigation.getY());
    assertEquals('N', navigation.getHeading());
    assertEquals("Obstacle at (0, 1) encountered!", radio.receive());
  }
}

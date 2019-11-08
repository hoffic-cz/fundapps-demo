package cz.hoffic.fundappsdemo;

import java.util.HashSet;

public class Navigation {

  public static final int DEFAULT_GRID_SIZE = 100;

  public final int gridSize;

  private Radio radio;
  private HashSet<Position> obstacles;

  private int x = 0;
  private int y = 0;

  /*
  The heading stored here can contain any value, it only collapses to 0-3 when
  getHeading() is called.
   */
  private char heading = 0;

  public Navigation() {
    gridSize = DEFAULT_GRID_SIZE;
    obstacles = new HashSet<>();
  }

  public Navigation(int gridSize) {
    this.gridSize = gridSize;
    obstacles = new HashSet<>();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getHeading() {
    while (heading < 0) {
      heading += 4;
    }

    while (heading >= 4) {
      heading -= 4;
    }

    char output;

    switch (heading) {
      case 0:
        output = 'N';
        break;
      case 1:
        output = 'E';
        break;
      case 2:
        output = 'S';
        break;
      case 3:
        output = 'W';
        break;
      default:
        throw new IllegalStateException();
    }

    return output;
  }

  private void turn(char way) {
    int change = 0;

    if (way == 'R') {
      change = 1;
    } else if (way == 'L') {
      change = -1;
    }

    heading += change;
  }

  private void move(int amount) {
    int startX = x;
    int startY = y;

    switch (getHeading()) {
      case 'N':
        y += amount;
        break;
      case 'E':
        x += amount;
        break;
      case 'S':
        y -= amount;
        break;
      case 'W':
        x -= amount;
        break;
      default:
        throw new IllegalStateException();
    }

    while (x < 0) {
      x += gridSize;
    }

    while (y < 0) {
      y += gridSize;
    }

    while (x >= gridSize) {
      x -= gridSize;
    }

    while (y >= gridSize) {
      y -= gridSize;
    }

    if (collided(x, y)) {
      announceCollision(x, y);

      x = startX;
      y = startY;
    }
  }

  private boolean collided(int x, int y) {
    var currentPosition = new Position(x, y);

    return obstacles.contains(currentPosition);
  }

  private void announceCollision(int x, int y) {
    radio.send(String.format(
        "Obstacle at (%s, %s) encountered!",
        x,
        y
    ));
  }

  public void command(String commands) {
    for (int i = 0; i < commands.length(); i++) {
      switch (commands.charAt(i)) {
        case 'F':
          move(1);
          break;
        case 'B':
          move(-1);
          break;
        case 'R':
          turn('R');
          break;
        case 'L':
          turn('L');
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
  }

  public void setRadio(Radio radio) {
    this.radio = radio;
  }

  public void addObstacle(Position position) {
    obstacles.add(position);
  }
}

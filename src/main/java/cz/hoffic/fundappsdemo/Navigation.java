package cz.hoffic.fundappsdemo;

public class Navigation {

  private int x = 0;
  private int y = 0;
  private char heading = 0;

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
}

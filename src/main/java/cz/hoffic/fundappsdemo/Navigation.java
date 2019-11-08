package cz.hoffic.fundappsdemo;

public class Navigation {

  private int x = 0;
  private int y = 0;
  private char heading = 'N';

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getHeading() {
    return heading;
  }

  public void command(String commands) {
    for (int i = 0; i < commands.length(); i++) {
      switch (commands.charAt(i)) {
        case 'F':
          y++;
          break;
        case 'B':
          y--;
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
  }
}

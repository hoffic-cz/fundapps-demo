package cz.hoffic.fundappsdemo;

public class Radio {

  private StringBuilder output;
  private boolean used = false;

  public Radio() {
    output = new StringBuilder();
  }

  public void send(String message) {
    if (used) {
      output.append("\n");
    } else {
      used = true;
    }

    output.append(message);
  }

  public String receive() {
    return output.toString();
  }
}

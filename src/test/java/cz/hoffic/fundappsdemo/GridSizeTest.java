package cz.hoffic.fundappsdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GridSizeTest {

  @Test
  public void defaultGridSize() {
    var navigation = new Navigation();

    assertEquals(Navigation.DEFAULT_GRID_SIZE, navigation.gridSize);
  }

  @Test
  public void CustomGridSize() {
    var navigation = new Navigation(1000);

    assertEquals(1000, navigation.gridSize);
  }
}

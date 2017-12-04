public class Grid {


  // Field
  private Square[][] grid = new Square[9][9];


  // Constructor
  // Assumes grid is always 9x9
  public Grid(int[][] values) {
    for (int i = 0; i < values.length; i++) {
      for (int j = 0; j < values.length; j++) {
        Square s;
        if (values[i][j] == 0) {
          s = new Square();
        } else {
          s = new Square(values[i][j]);
        }
        grid[i][j] = s;
      }
    }
    removeSurplusPMarks();
  }


  // Methods
  public void printGrid() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        grid[i][j].print();
      }
      System.out.println();
    }
  }

  public boolean hasFreeSpace() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        if (grid[i][j].isEmpty()) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isGoodMove(int row, int col) {
    return grid[row][col].hasUniquePMark();
  }

  public void makeMove(int row, int col) {
    assert isGoodMove(row, col) : "Wrong move made!";
    grid[row][col] = new Square(grid[row][col].uniquePMark());
  }

  // Current algorithm very simplistic and only solves simple problems.
  // Adding more strategies will improve the power of the solver.
  private void removeSurplusPMarks() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        removePMarks(i, j);
      }
    }
  }

  public void removePMarks(int row, int col) {
    // Pre: makeMove has been called before this method.
    // This method removes the pencilmarks that are no longer correct because
    // of the value at grid[row][col]
    int num = grid[row][col].value();
    removeInRow(num, row);
    removeInCol(num, col);
    removeInBlock(num, row, col);
  }

  private void removeInRow(int num, int row) {
    for (int i = 0; i < grid.length; i++) {
      // has no effect if the given pencil mark isn't in the square
      grid[row][i].removePMarkifThere(num);
    }
  }

  private void removeInCol(int num, int col) {
    for (int i = 0; i < grid.length; i++) {
      // has no effect if the given pencil mark isn't in the square
      grid[i][col].removePMarkifThere(num);
    }
  }

  private void removeInBlock(int num, int row, int col) {
    int startRow = startIndex(row); //TODO:
    int startCol = startIndex(col);
    for (int i = startRow; i <= startRow + 2; i++) {
      for (int j = startCol; j <= startCol + 2; j++) {
        // has no effect if the given pencil mark isn't in the square
        grid[i][j].removePMarkifThere(num);
      }
    }
  }

  private int startIndex(int n) {
    assert (0 <= n) && (n <= 9) : "requires a number in the range 0 to 8";
    switch (n) {
      case 0:
      case 1:
      case 2:
        return 0;
      case 3:
      case 4:
      case 5:
        return 3;
      default:
        return 6;
    }
  }
}

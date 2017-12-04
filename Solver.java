public class Solver {
  // this works for simple games. The algorithm is called a 'naked ones'
  // solution. a more sophisticated apporach would be to look for pairs of
  // pencil marks and elminiate them this way (naked two and hidden tw
  // solutions).

  static int[][] game = {
      {0, 6, 0, 3, 0, 0, 8, 0, 4},
      {5, 3, 7, 0, 9, 0, 0, 0, 0},
      {0, 4, 0, 0, 0, 6, 3, 0, 7},
      {0, 9, 0, 0, 5, 1, 2, 3, 8},
      {0, 0, 0, 0, 0, 0, 0, 0, 0},
      {7, 1, 3, 6, 2, 0, 0, 4, 0},
      {3, 0, 6, 4, 0, 0, 0, 1, 0},
      {0, 0, 0, 0, 6, 0, 5, 2, 3},
      {1, 0, 2, 0, 0, 9, 0, 8, 0},
  };

  // a game that is too difficult to solve with this algorithm (it finds the
  // first three numbers before there are no squares with only one pencil mark).
  static int[][] game1;


  public static void main(String[] args) {
    Grid grid = new Grid(game);
    System.out.println("the given grid is: ");
    grid.printGrid();
    while (grid.hasFreeSpace()) {
      // when there is a free space there will always be at least one space that
      // has only one pencil mark (as it is an easy sudoku)
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (grid.isGoodMove(i, j)) {
            grid.makeMove(i, j);
            grid.removePMarks(i, j);
          }
        }
      }
    }
    System.out.println("the solution is: ");
    grid.printGrid();
  }

}

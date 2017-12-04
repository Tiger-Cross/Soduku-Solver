public class Square {


  // Fields
  // Value is a number between 1 and 9, 0 if the square is empty
  private final int value;
  // The possible entries for that square
  private boolean[] pMarks;
  // The number of pencil marks
  private int numPMarks;


  // Constructors
  // Creates an empty square
  public Square() {
    this.value= 0;
    this.pMarks = new boolean[]{true, true, true, true, true, true, true,
        true, true};
    this.numPMarks = 9;
  }

  // Creates a square containing a value
  public Square(int value) {
    assert value >= 1 && value <= 9 : "value must be between 1 and 9";
    this.value = value;
    this.pMarks = new boolean[]{false, false, false, false, false, false,
        false, false, false};
    this.numPMarks = 0;
  }


  // Methods
  // This method simply helps to debug.
  private void printAll() {
    System.out.println("The Value is = " + value + ", number of pencilMarks: "
        + "" + numPMarks);
    System.out.print("{");
    for (boolean pMark : pMarks) {
      System.out.println(pMark + ", ");
    }
  }

  public int value() {
    return this.value;
  }

  public boolean isEmpty() {
    return this.value == 0;
  }

  public boolean hasUniquePMark() {
    return numPMarks == 1;
  }

  public int uniquePMark() {
    assert hasUniquePMark() : "must have only one pencil mark";
    for (int i = 0; i < pMarks.length; i++) {
      if (pMarks[i]) {
        return i + 1;
      }
    }
    return 0; // will never reach here because of the assertion.
  }

  public void removePMarkifThere(int n) {
    assert 0 <= n && n <= 9;
    if (n > 0 && pMarks[n - 1]) {
      pMarks[n - 1] = false;
      numPMarks--;
    }
  }

  public void print() {
    System.out.print(value + " ");
  }
}



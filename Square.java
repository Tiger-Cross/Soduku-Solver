import java.util.stream.IntStream;

public class Square {

  private int value = 0;

  private boolean[] pMarks = new boolean[] {true,true,true,true,true,true,
      true,true,true};

  private int numPMarks = 9;

  public Square() {}

  public Square(int value) {
    this.value = value;
  }


  private int value() {
    assert 1 <= this.value && this.value <= 9 : "square must have a value "
        + "between 1 and 9";
    return this.value;
  }

  private boolean isEmpty() {
    boolean result = this.value == 0;
    return result;
  }

  public int getNumPMarks() {
    return this.numPMarks;
  }

  private boolean hasUniquePMark() {
    boolean result = numPMarks == 1;
    return result;
  }

  private int uniquePMark() {
    if (hasUniquePMark()) {
      value();
    }
  }

  private void removePMarkifThere(int n) {
    if () {
      //change numpmarks in here

    }
  }

  private String toString() {

  }
}



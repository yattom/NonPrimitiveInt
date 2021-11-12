public class Counter implements Comparable<Counter> {
  public static final Counter ORIGIN = new Counter();

  private Counter _next = null;

  public Counter next() {
    if(this._next == null) {
      this._next = new Counter();
    }
    return this._next;
  }

  public int compareTo(Counter other) {
    final int THIS_IS_LESSER_THAN_OTHER = -1;
    final int THIS_IS_GREATER_THAN_OTHER = 1;
    if(other == null) {
      throw new IllegalArgumentException();
    }
    if(this.equals(other)) {
      return 0;
    }

    var point = ORIGIN;
    while(true) {
      if(point.equals(this)) {
        return THIS_IS_LESSER_THAN_OTHER;
      }
      if(point.equals(other)) {
        return THIS_IS_GREATER_THAN_OTHER;
      }
      point = point.next();
    }
  }

}
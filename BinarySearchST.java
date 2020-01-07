import java.util.*;

public class BinarySearchST<Key extends Comparable, Value> {
  private List<Key> keys;
  private List<Value> values;

  public BinarySearchST() {
    this.keys = new ArrayList<Key>();
    this.values = new ArrayList<Value>();
  }

  public void put(Key key, Value val) {
    for (int i = 0; i < this.keys.size(); i++)
      if (this.keys.get(i).compareTo(key) > 0) {
        this.keys.add(i, key);
        this.values.add(i, val);
        return;
      } else if (this.keys.get(i).compareTo(key) == 0) {
        return;
      }

    this.keys.add(key);
    this.values.add(val);
  }

  public Value get(Key key) {
    return search(key, 0, this.keys.size() - 1);
  }

  private Value search(Key key, int lo, int hi) {
    if (lo >= hi)
      return null;

    int mid = (hi + lo) / 2;

    if (this.keys.get(mid).compareTo(key) == 0)
      return this.values.get(mid);
    else if (this.keys.get(mid).compareTo(key) < 0)
      return search(key, mid + 1, hi);
    else
      return search(key, lo, mid - 1);
  }

  @Override
  public String toString() {
    String result = "";

    for (int i = 0; i < this.keys.size(); i++)
      result += "{ " + this.keys.get(i) + " : " + this.values.get(i) + " }";
    
    return result;
  }
}

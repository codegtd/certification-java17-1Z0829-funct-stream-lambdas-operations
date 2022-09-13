package entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Guest implements Comparable<Guest> {
  public String first;
  public String last;

  @Override
  public int compareTo(Guest o) {

    return last.compareToIgnoreCase(o.last);
  }

  /*
    @Override
    public int compare(Product product1, Product product2) {
     if(product1.price < product2.price) return -1;
     if(product1.price > product2.price) return +1;
     return 0;
    }
 */
  public static int same_args_and_return_than_Compare_from_ComparatorInterface(Guest g1, Guest g2) {
    return g1.first.compareToIgnoreCase(g2.first);
  }
}
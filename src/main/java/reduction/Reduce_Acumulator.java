package reduction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce_Acumulator {
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1, 2, 3, 4);
    final Optional<Integer> reduction =
         list.stream()
             .reduce((subtotal, cumulate_in_subtotal) -> {

               show("subtotal: " + subtotal +
                         " - Cumulator: " + cumulate_in_subtotal);

       // Associate Acumulation: Function cumulating in SubTotal
               return subtotal + cumulate_in_subtotal;    });

    final Integer intRed = reduction.get();
    show("Reduction = " + intRed);
  }

  private static void show(String text) {

    System.out.println(text);
  }
}
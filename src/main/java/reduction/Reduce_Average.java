package reduction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Reduce_Average {
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    final OptionalDouble average =
         list.stream()
             .mapToInt((s) -> s)
             .average();
    double avg = average.orElse(- 1);

    final Optional<Integer> reduction =
         list
              .stream()
              .reduce((subtotal, cumulate_in_subtotal) -> {
                show("subtotal: " + subtotal +
                          " - Cumulator: " + cumulate_in_subtotal);
                // Associate Acumulation: Function cumulating in SubTotal
                return subtotal + cumulate_in_subtotal;
              });
    final Integer intRed = reduction.get();

    int sum =
         list.stream()
             .mapToInt((s) -> s)
             .sum();

    show("Aver: " + avg + "|Sum: " + sum + "|Red = " + intRed);

  }

  private static void show(String text) {

    System.out.println(text);
  }
}
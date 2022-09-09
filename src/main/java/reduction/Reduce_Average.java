package reduction;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Reduce_Average {
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1, 2, 3);

    final OptionalDouble average =
         list.stream()
             .mapToInt((s) -> s)
             .average();

    double avg = average.orElse(- 1);

       int sum = list.stream()
                  .mapToInt((s) -> s)
                  .sum();

    double red = list.stream()
                     .reduce((total, currentElement) -> total + currentElement)
                     .orElse(- 1);

    show("Aver: " + avg + "|Sum: " + sum + "|Red = " + red);

  }

  private static void show(String text) {

    System.out.println(text);
  }
}
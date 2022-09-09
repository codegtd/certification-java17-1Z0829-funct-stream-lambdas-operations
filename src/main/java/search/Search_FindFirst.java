package search;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Search_FindFirst {
  public static void main(String[] args) {

    Random r = new Random();

    Optional<Integer> first =
         Stream.generate(() -> r.nextInt(5))
               .limit(3)
               .peek(System.out::println)
               .sorted()
               .findFirst();

    first.ifPresent(System.out::print);

    List<String> empty = List.of();

    Optional<String> firstStr = empty.stream()
                                     .findFirst();
    System.out.print("First found? ");
    firstStr
         .ifPresentOrElse(
              System.out::print,
              () -> show("Nope")
         );
  }

  private static void show(String text) {

    show(text);
  }
}
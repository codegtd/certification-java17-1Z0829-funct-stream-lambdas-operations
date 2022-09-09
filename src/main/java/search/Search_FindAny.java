package search;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Search_FindAny {
  public static void main(String[] args) {

    Random r = new Random();
    Optional<Integer> any =
         Stream.generate(() -> r.nextInt(5))
               .limit(3)
               .peek(System.out::println)
               .sorted()
               .findAny();

    any.ifPresent(System.out::print);

    List<String> empty = List.of();

    Optional<String> anyStr =
         empty.stream()
              .findAny();

    System.out.print("Any found? ");
    anyStr
         .ifPresentOrElse(
              System.out::print,
              () -> show("Nope")
         );
  }

  private static void show(String text) {

    show(text);
  }
}
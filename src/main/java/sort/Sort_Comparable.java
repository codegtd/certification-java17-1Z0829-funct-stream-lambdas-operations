package sort;

import entity.Guest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Sort_Comparable {

  public static void main(String[] args) {

    List<String> strings = List.<String>of("Ball", "Charles", "Abc");

    // HashSet is unordered
    Set<String> unOrderedSet = new HashSet<String>(strings);

    final Guest[] guests = {
         new Guest("Ann", "Jones"),
         new Guest("Bob", "Smith"),
         new Guest("Carol", "Green")};

    // 3.4) Reverse-Sort-Comparable-REFERENCE:
    //      a) ".sorted()": must "refer" to a method with same arg's+return than
    //         comparators-Interface-Compare-Method.
    //      b) "ReverseOrder": returns a comparator.
    Stream.of(guests)
    //  .sorted(Comparator::reverseOrder) // COMPILE-ERROR
          .forEach(guest -> show("Reverse-Comparable: " + guest));

    // 3.4) SOLUTIONS:
    // 3.4.1) use Static Method
    Stream.of(guests)
          .sorted(Comparator.reverseOrder()) // Guest implements "Comparable"
          .forEach(guest -> show("Reverse-Comparable: " + guest));

    // 3.4.2) create method with same arg's+return than
    //        comparators-Interface-Compare-Method.
    Stream.of(guests)
          .sorted(Guest::same_args_and_return_than_Compare_from_ComparatorInterface)
          .forEach((s) -> show(s.first + " " + s.last));
  }


  private static void show(String text) {

    System.out.println(text);
  }
}
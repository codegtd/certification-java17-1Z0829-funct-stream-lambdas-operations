package sort;

import entity.Guest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Sort_Lambda {

  public static void main(String[] args) {

    List<String> strings = List.<String>of("Ball", "Charles", "Abc");

    // HashSet is unordered
    Set<String> unOrderedSet = new HashSet<String>(strings);

    final Guest[] guests = {
         new Guest("Ann", "Jones"),
         new Guest("Bob", "Smith"),
         new Guest("Carol", "Green")};

    // 3) Sorting Styles:
    // 3.1) Lambda - Comparing LastName[instance-variable]:
    Stream.of(guests)
          .sorted((s, t) -> s.last.compareToIgnoreCase(t.last))
          .forEach(guest -> show("Lambda Sort: " + guest));

    // 3.2) Multiple-Lambdas - Comparing LastName[instance-variable]:
    strings
         .stream()
         .sorted((s, t) -> s.length() - t.length())
         .peek((s) -> System.out.println(s + " "))
         .sorted(Comparator.naturalOrder())
         .forEach((s) -> show(s + " "));
  }


  private static void show(String text) {

    System.out.println(text);
  }
}
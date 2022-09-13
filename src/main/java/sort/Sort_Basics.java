package sort;

import entity.Guest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Sort_Basics {

  public static void main(String[] args) {

    List<String> strings = List.<String>of("Ball", "Charles", "Abc");

    // HashSet is unordered
    Set<String> unOrderedSet = new HashSet<String>(strings);

    final Guest[] guests = {
         new Guest("Ann", "Jones"),
         new Guest("Bob", "Smith"),
         new Guest("Carol", "Green")};

    // 01) Simple Sort
    // - Natural-Order(alphabetical), String implements "Comparable"
    strings.stream()
           .sorted()
           .forEach((s) -> show("Simple Sort: " + s + " "));

    // 02) Compile-Error:
    // - Object MUST implements "Comparable"
    Stream.of(guests)
          //.sorted()
          //.sorted(Comparator.naturalOrder())
          .forEach(System.out::println);

    // 3.2) Simple-Sort-Comparable:
    Stream.of(guests)
          .sorted() // Guest implements "Comparable"
          .forEach(guest -> show("Simple-Comparable: " + guest));
  }


  private static void show(String text) {

    System.out.println(text);
  }
}
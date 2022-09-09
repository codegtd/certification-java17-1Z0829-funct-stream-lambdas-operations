package search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Search_Matches {
  public static void main(String[] args) {

    List<String> initialData = List.<String>of("One", "Two");
    Set<String> mySet = new HashSet<String>(initialData);

    boolean anyMatch =
         mySet.stream()
              .anyMatch((s) -> s.length() == 6);

    boolean allMatch =
         mySet.stream()
              .allMatch((s) -> s.length() == 3);

    boolean noneMatch =
         mySet.stream()
              .noneMatch((s) -> s.length() == 6);

    show("03 Length: " + anyMatch +
              "\n03 Length: " + allMatch +
              "\n06 Length:" + noneMatch);

    List<String> empty = List.of();
    anyMatch = empty.stream()
                     .anyMatch((s) -> s.length() == 6);

    allMatch = empty.stream()
                     .allMatch((s) -> s.length() < 6);

    noneMatch = empty.stream()
                      .noneMatch((s) -> s.length() == 6);

    show("03 Length: " + anyMatch +
              "\n03 Length: " + allMatch +
              "\n06 Length:" + noneMatch);

  }

  private static void show(String text) {

    System.out.println(text);
  }
}
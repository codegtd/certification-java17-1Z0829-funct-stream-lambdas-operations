package collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collector_Basics {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>(List.of("First", "Second"));

    List<String> aList =
         list
              .stream()
              .map((s) -> s + "ish")
              .collect(Collectors.toList());

    aList.add("Fourthish");
    show("First: " + list + "\n" + "Second: " + aList);
  }

  private static void show(String text) {

    System.out.println(text);
  }
}
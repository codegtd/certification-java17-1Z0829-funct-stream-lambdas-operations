package collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collector_Joining {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>(List.of("First", "Second"));

    String j1 = list.stream().collect(Collectors.joining());
    String j2 = list.stream().collect(Collectors.joining(", "));
    String j3 = list.stream().collect(Collectors.joining(", ", "List [", "]"));

    show("Joining: No parameters: " + j1);
    show("Joining: Delimiter : " + j2);
    show("Joining: Delimiter," + " prefix and suffix : " + j3);
  }

  private static void show(String text) {

    System.out.println(text);
  }
}
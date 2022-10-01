package collector;

import entity.Pet;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static entity.Pet.getPets;

public class Collector_Partition_Advanced1 {
  public static void main(String[] args) {

    // PARTITIONS STORAGED IN MAP (Map is Default):
    // 1)  TRUE-PART.: "Dogs"
    // 2) FALSE-PART.: "Others"
    Map<Boolean, List<Pet>> partition =
         getPets()
              .stream()
              .limit(20)
              .collect(
                   Collectors
                        .partitioningBy(s -> s.getType().equals("Dog")));

    show("FIRST 20 DOGS:\n * TRUE-PARTITION ones");
    partition
         .entrySet()
         .stream()
         .filter((s) -> s.getKey() == true)         // Key is "TRUE"
         // Flatten list of Pets to a Stream
         .flatMap(s -> s.getValue().stream())
         .limit(3)
         .forEach(System.out::println);

    show("\nFIRST 20 DOGS:\n * FALSE-PARTITION ones");
    partition
         .entrySet()
         .stream()
         .filter((s) -> s.getKey() == false)         // Key is "FALSE"
         // Flatten list of Pets to a Stream
         .flatMap(s -> s.getValue()
                        .stream())
         .limit(3)
         .forEach(System.out::println);
  }

  private static void show(String text) {

    System.out.println(text);
  }
}
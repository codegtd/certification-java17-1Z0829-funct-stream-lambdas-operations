package collector;

import entity.Pet;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static entity.Pet.getPets;

public class Collector_Partitioning {
  public static void main(String[] args) {

    // TRUE-FALSE PARTITIONS:
    // 1)  TRUE-PARTITION: "Dogs"
    // 2) FALSE-PARTITION: "All others"
    Map<Boolean, List<Pet>> partition =
         getPets()
              .stream()
              .collect(
                   Collectors
                        .partitioningBy(s -> s.getType().equals("Dog")));

    System.out.println("TRUE-PARTITION: First 05 dogs");
    partition
         .entrySet()
         .stream()
         .filter((s) -> s.getKey())         // Key is "TRUE"
         // Flatten list of Pets to a Stream
         .flatMap(s -> s.getValue().stream())
         .limit(3)
         .forEach(System.out::println);

    System.out.println("\nFALSE-PARTITION: First 05 pets");
    partition
         .entrySet()
         .stream()
         .filter((s) -> ! s.getKey())         // Key is "FALSE"
         // Flatten list of Pets to a Stream
         .flatMap(s -> s.getValue()
                        .stream())
         .limit(3)
         .forEach(System.out::println);

    System.out.println("TRUE-PARTITION (full chain): First 03 dogs");
    getPets()
         .stream()
         .collect(
              Collectors
                   .partitioningBy(s -> s.getType().equals("Dog"))
         )
         .entrySet()
         .stream()
         .filter((s) -> s.getKey())         // Key is "TRUE"
         .peek(System.out::println)
         .flatMap(s -> s.getValue().stream())// Flatten list-Pets in a Stream
         .limit(3)
         .forEach(System.out::println);

    // TRUE-FALSE PARTITIONS:
    // 1)  TRUE-PARTITION: "Dogs"
    // 2) FALSE-PARTITION: "All others"
    show("\nJust print dog population by veterinary type");
    getPets()
         .stream()
         .collect(
              Collectors
                   .partitioningBy(          // Map<Boolean, Map<String,Long>
                      s -> s.getType().equals("Dog"), // 1 TRUE-PARTITION
                      Collectors.groupingBy(
                           Pet::getVet,            // 2.1 Group by Vet
                           TreeMap::new,           // 2.2 Storage in TreeMap
                           Collectors.counting()   // 2.3 Count
                      )
              ))
         .entrySet()
         .stream()
         .filter((s) -> s.getKey())
         .forEach(System.out::println);

  }

  private static void show(String text) {

    System.out.println(text);
  }
}
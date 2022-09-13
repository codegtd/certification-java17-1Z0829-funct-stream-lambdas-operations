package collector;

import entity.Pet;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector_Grouping {
  public static void main(String[] args) {

    System.out.println(new Pet());

    List<Pet> petPopulation =
         Stream.generate(Pet::new)
               .limit(5000)
               .collect(Collectors.toList());

    show("N. Dogs = " +
              petPopulation
                   .stream()
                   .filter((s) -> s.getType() == "Dog")
                   .count());

    Map<String, Long> petTypeCounts =
         petPopulation
              .stream()
              // Collects to Map<String,Long> where key=pet type
              .collect(
                   Collectors.groupingBy(
                        Pet::getType,
                        Collectors.counting()
                   ));

    System.out.println("--- Counts by Pet Type: ---");
    // Create a stream from Map.entrySet()
    petTypeCounts.entrySet()
                 .stream()
                 // Sort stream by pet type (key for Map)
                 .sorted((s, t) -> s.getKey()
                                    .compareTo(t.getKey()))
                 // Print element: a key/value pair
                 .forEach(System.out::println);

  }

  private static void show(String text) {

    System.out.println(text);
  }
}
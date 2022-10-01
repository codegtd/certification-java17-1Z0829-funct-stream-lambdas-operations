package collector;

import entity.Pet;

import java.util.TreeMap;
import java.util.stream.Collectors;

import static entity.Pet.getPets;

public class Collector_Partition_Advanced2 {
  public static void main(String[] args) {

    getPets()
         .stream()
         .collect(
         // PARTITIONS STORAGED IN MAP (Map is Default):
         // 1)  TRUE-PART.: "Dogs"
         // 2) FALSE-PART.: "Others"
              Collectors
                   .partitioningBy(s -> s.getType().equals("Dog"))
         )
         .entrySet()
         .stream()

         // 3)  SHOW ONLY TRUE-PART.: "Dogs"
         .filter((partitionMap) -> partitionMap.getKey() == true)
         .peek(partitionTrue -> {
           show("1) PARTITION 'TRUE' items:");
           System.out.println(partitionTrue);
         })
         .flatMap(partitionMap -> partitionMap.getValue().stream())
         .limit(3)

         // 4)  SHOW ONLY TRUE-PART.: "Dogs"
         .forEach(petFromStream -> {
           show("\nItem(03 items) from PARTITION 'TRUE':");
           System.out.println(petFromStream);
         });

    show("\nTOTAL-DOGS FROM VET-TYPE:");
    getPets()
         .stream()
         .collect(
              // PARTITIONS STORAGED IN TREE-MAP (Map is Default):
              // 1)  TRUE-PARTITION: "Dogs"
              // 2) FALSE-PARTITION: "All others"
              Collectors
                   .partitioningBy(s -> s.getType().equals("Dog"),
                        Collectors.groupingBy(
                             Pet::getVet,          // 1.1 Group by Vet
                             TreeMap::new,         // 1.2 Store in TreeMap
                             Collectors.counting() // 1.3 Count/Total
                        )))
         .entrySet()
         .stream()
              // 3) SHOW ONLY "TRUE" ONES
         .filter((partitionMap) -> partitionMap.getKey() == true)
         .forEach(treeMapEntry -> {
           System.out.println(treeMapEntry);
         });

  }

  private static void show(String text) {

    System.out.println(text);
  }
}
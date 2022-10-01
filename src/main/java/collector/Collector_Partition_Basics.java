package collector;

import entity.Pet;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static entity.Pet.getPets;

public class Collector_Partition_Basics {
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
    System.out.println("TRUE-PARTITION: First 20 dogs" + partition );
  }

  private static void show(String text) {

    System.out.println(text);
  }
}
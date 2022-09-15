package collector;

import entity.Pet;
import entity.PetTim;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector_toMap_GroupBy {
  public static void main(String[] args) {

    List<PetTim> petPopulation =
         Stream.generate(PetTim::new)
               .limit(3)
               .collect(Collectors.toList());

    System.out.println("\n0) Listing Pets");
    petPopulation.forEach(System.out::println);

/*╔═════════════════════════════════════════════════════════╗
  ║                   COLLECTOR GROUP_BY                    ║
  ╠═════════════════════════════════════════════════════════╣
  ║1) Relation:  ONE -> MANY                                ║
  ║1.1) Map<K, List<V>>  <->  Ex.: Map<String, List<PetNew>>║
  ║     - K: Custom | List<V>: Default                      ║
  ║1.2) Allow Duplicities in List<V>                        ║
  ╚═════════════════════════════════════════════════════════╝*/
    System.out.println("\n1) GROUP_BY - 1 ARG");
    petPopulation.stream()
                 .collect(
                      Collectors
                           .groupingBy(
                                p -> p.getType() + "Custom"
//                                PetTim::getType
                           ))
                 .entrySet()
                 .stream()
                 .forEach(System.out::println);

/*╔══════════════════════════════════════════════════════════╗
  ║                     COLLECTOR TO_MAP                     ║
  ╠══════════════════════════════════════════════════════════╣
  ║1) Relation:  ONE -> ONE                                  ║
  ║1.1) Map<K, V>   <->   Ex.: Map<String, PetNew>           ║
  ║     - K: Custom(Unique) | V: Custom                      ║
  ║1.2) PROBLEM: "NOT-ALLOW" Duplic's in <K> (Unique)        ║
  ║     SOLUTION: a)Distinct; b)Unique-Key to avoid Duplic's ║
  ╚══════════════════════════════════════════════════════════╝*/
    System.out.println("\n2) TO_MAP - 2 ARGs");
    petPopulation.stream()
                 .distinct()
                 .collect(
/*╔═══════════════════════════════════════════════════════════╗
  ║SCEN-01: "type" DUPLIC | "name" NO-DUPLIC                  ║
  ║SCEN-02: "type" DUPLIC | "name"    DUPLIC  => KEY NO-UNIQUE║
  ╚═══════════════════════════════════════════════════════════╝*/
                    Collectors.toMap(
                         p -> "My" +p.getType() + "_" + p.getName(),
                         p -> p
                    ))
                 .entrySet()
                 .stream()
                 .forEach(System.out::println);


    System.out.println("\n3) GROUP_BY - 1 ARG - TREE_MAP");
    petPopulation
         .stream()
            .collect(
                 Collectors
                      .groupingBy(
                           PetTim::getType,
                           TreeMap::new,
                           Collectors.toList()))
            .entrySet()
            .stream()
            .forEach(System.out::println);


    System.out.println("\n4) TO_MAP - 2 ARG's - TREE_MAP");
    petPopulation
         .stream()
            .distinct()
            .collect(
                 Collectors
                      .toMap(
                          p -> p.getType() + "_" + p.getName(),
                          p -> p,
                          // merge function ignored if not parallel
                          (existing, replacement) -> existing,
                          TreeMap::new))
            .entrySet()
            .stream()
            .forEach(System.out::println);

  }
}
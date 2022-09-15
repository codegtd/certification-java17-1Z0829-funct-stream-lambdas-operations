package collector;

import entity.Pet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static entity.Pet.getPets;

public class Collector_GroupBy {
  public static void main(String[] args) {

    List<Pet> petPopulation = getPets();


    //GROUP-01-ATTRIB + COUNT
    getPets()
         .stream()
         .collect(Collectors
                   .groupingBy(Pet::getType,
                   Collectors.counting()))
         .entrySet()
         .stream()
         .sorted((prev, next) -> prev.getKey().compareTo(next.getKey()))
         .forEach(System.out::println);


    show("--- Counts by State, PetType: ---");


    //GROUP-02-ATTRIB + COUNT
    getPets()
             .stream()
             .collect(Collectors
                           .groupingBy(
                                p -> Arrays.asList(p.getState(), p.getType()),
                                Collectors.counting()))
             .entrySet()
             .stream()
             .sorted(Comparator.comparing(
                              s -> (s.getKey().get(0) + s.getKey().get(1))))
             .filter((s) ->
                          (s.getKey().get(1).equals("Cat") ||
                           s.getKey().get(1).equals("Dog")))
             .forEach(System.out::println);
  }

  private static void show(String text) {

    System.out.println(text);
  }
}
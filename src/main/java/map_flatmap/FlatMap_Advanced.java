package map_flatmap;

import entity.Pet;
import entity.PetTim;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap_Advanced {
  public static void main(String[] args) {

    Map<String, List<String>> students = new HashMap<>();
    students.put("Alfred", List.of("111-111-111", "222-222-222"));
    students.put("Barney", List.of("333-333-333", "444-444-444"));

    final List<String> list =
         students
              .values()
              .stream()
              .flatMap(phone -> {
                List<String> list1 =
                     phone.stream()
                          .map(phone1 -> phone1.replace("-", "+"))
                          .collect(Collectors.toList());
                return list1.stream();
              })
              .toList();
    list.forEach(System.out::println);


    final List<Stream<String>> streamList =
         students.values()
                 .stream()
                 .map(phone -> {
                   List<String> list2 =
                        phone.stream()
                             .map(phone1 -> phone1.replace("-", "|"))
                             .collect(Collectors.toList());
                   return list2.stream();
                 })
                 .toList();
    for (Stream<String> x : streamList) {
      List<String> phones = x.collect(Collectors.toList());
      System.out.println(phones);
    }

/*╔═════════════════════════════════════════════════════════╗
  ║               MAP BEING USED AS FLAT_MAP                ║
  ╚═════════════════════════════════════════════════════════╝*/
    List<PetTim> petList1 = List.of(new PetTim(), new PetTim());
    List<PetTim> petList2 = List.of(new PetTim(), new PetTim());
    List<List<PetTim>> matrix_of_lists_ListOfLists = List.of(petList1, petList2);

    matrix_of_lists_ListOfLists.forEach(System.out::println);

    System.out.println("\n--- Faking FlatMap using Map ---");
    List<PetTim> list1 = new ArrayList<PetTim>();
    matrix_of_lists_ListOfLists
       .stream()
       .map(s -> list1.addAll(s))
       .allMatch(p -> p != null);
    list1.forEach(System.out::println);

    System.out.println("\n--- Classic flatMap Variations---");
    matrix_of_lists_ListOfLists
      .stream()
         // .flatMap(s -> s.stream())  //   Work|flats: List<Pet>
         .flatMap(Collection::stream)  //   Work|flats: List<Pet>
         // .flatMap(Stream::of)       //No Work|No flats: List<List<Pet>>
         .collect(Collectors.toList())
         .forEach(System.out::println);

 }
}
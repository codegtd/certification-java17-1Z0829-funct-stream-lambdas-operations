import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap_advanced {
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

  }
}
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap_basics {
  public static void main(String[] args) {
    List<Integer> mapExampleList = Arrays.asList(1, 2, 3);

    List<Integer> mapResultList =
         mapExampleList
              .stream()
              .map(x -> ++ x)
              .peek(System.out::println)
              .collect(Collectors.toList());

    System.out.println(mapResultList);

    List<List<Integer>> matrix_listOfList =
         List.of(Arrays.asList(1, 2, 3),
                 Arrays.asList(1, 2, 3)
         );

    List<Integer> mergedList =
         matrix_listOfList
              .stream()
              .flatMap(x -> {
                return x.stream();
              })
              .collect(Collectors.toList());

    System.out.println(mergedList);
  }
}
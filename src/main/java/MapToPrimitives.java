import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToPrimitives {
  public static void main(String[] args) {

    System.out.println("Output IntStream using map");
    IntStream.iterate(5, (t) -> t + 5)
             .limit(3)
             .map((s) -> s * 1000)
             // COMPILE-ERROR:
             // 1) .mapToInt is NOT AVAILABLE in "IntStream"
             // .mapToInt((s) -> s * 1000)
             .forEach((s) -> show(s + " "));

    System.out.println("\nOutput Stream using mapToInt");
    Stream.<Integer>iterate(5, (t) -> t + 5)
          .limit(3)
          .mapToInt((s) -> s * 1000)
          .map((s) -> s * 1000)
          // COMPILE-ERROR:
          // 1) .mapToInt is in "Stream<Integer>"
          // 2) .mapToInt converted: "Stream<Integer>" to "IntStream"
          // 3) .mapToInt 'NOW' is NOT AVAILABLE in "IntStream"
          // .mapToInt((s) -> s * 1000)
          .forEach((s) -> show(s + " "));
  }

  private static void show(String element) {

    System.out.println(element);
  }
}
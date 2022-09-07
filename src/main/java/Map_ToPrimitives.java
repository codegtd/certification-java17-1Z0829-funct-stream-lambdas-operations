import java.util.stream.IntStream;
import java.util.stream.Stream;

/*╔════════════════════════════════════════╗
  ║   MAPtoINT - MAPtoDOUBLE - MAPtoLONG   ║
  ╠════════════════════════════════════════╣
  ║         CONVERT a "Stream" in          ║
  ║  Stream of Primitive [Int/Double/Long] ║
  ╚════════════════════════════════════════╝*/
public class Map_ToPrimitives {
  public static void main(String[] args) {

    System.out.println("Output IntStream using map");
    IntStream.iterate(5, (t) -> t + 5)
             .limit(3)
             .map((s) -> s * 1000)
             // COMPILE-ERROR:
             // 1) "IntStream" does not support ".mapToInt"
             // .mapToInt((s) -> s * 1000)
             .forEach((s) -> show(s + " "));

    System.out.println("\nOutput Stream using mapToInt");
    Stream.<Integer>iterate(5, (t) -> t + 5)
          .limit(3)
          .mapToInt((s) -> s * 1000)
          .map((s) -> s * 1000)
          // COMPILE-ERROR:
          // 1) .mapToInt is supported by "Stream<Integer>"
          // 2) .mapToInt is AVAILABLE
          // 3) .mapToInt converted "Stream<Integer>" in "IntStream"
          // 4) "IntStream"(converted) does not support ".mapToInt"
          // .mapToInt((s) -> s * 1000)
          .forEach((s) -> show(s + " "));
  }

  private static void show(String element) {

    System.out.println(element);
  }
}
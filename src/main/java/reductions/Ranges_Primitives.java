package reductions;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ranges_Primitives {
  public static void main(String[] args) {

    IntSummaryStatistics intStats =
         IntStream
              .range(1, 3) // IntStream Range (Incl + Excl)
              .summaryStatistics();
    System.out.println(intStats.getAverage());

    LongSummaryStatistics longStats =
         LongStream
              .rangeClosed(1, 3)// LongStream Range (Incl + Incl)
              .summaryStatistics();
    System.out.println(longStats.getSum());

    OptionalInt ma = IntStream.range(1, 5).max();
    OptionalLong mi = LongStream.range(1, 5).min();
    OptionalDouble av = DoubleStream.iterate(1.0, s -> s < 10.0, s -> s + 1)
                                    .average();
    int sm = IntStream.iterate(5, s -> s < 10, s -> s + 1).sum();
    showFull(ma, mi, av, sm);

    DoubleSummaryStatistics stats =
         Stream.iterate(1, s -> s <= 3, s -> s + 1)
               .mapToInt(s -> s)
               .boxed()
               .mapToDouble(s -> s)
               .summaryStatistics();
    System.out.println(stats);
  }

  private static void showFull(OptionalInt ma, OptionalLong mi, OptionalDouble av, int sm) {

    show("Max:" + ma);
    show("Avg:" + av);
    show("Min:" + mi);
    show("Sum: " + sm);
  }

  private static void show(String text) {

    System.out.println(text);
  }
}
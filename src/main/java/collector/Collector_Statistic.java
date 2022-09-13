package collector;

import entity.CollectStudent;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector_Statistic {
  public static void main(String[] args) {

    IntSummaryStatistics firstStats =
         new Random().ints(1, 10)
                     .limit(1000)
                     .summaryStatistics();
    System.out.println(firstStats);

    // Get Summary Statistics from a Stream<Integer>
    IntSummaryStatistics secondStats =
         new Random().ints(1, 10)
                     .limit(1000)
                     .boxed()
                     .collect(
                          Collectors.summarizingInt((s) -> s));
    System.out.println(secondStats);

    // Get Summary Statistics (about the gpa) from a Stream<Student>
    DoubleSummaryStatistics gpaStats =
         Stream.of(new CollectStudent("Jeff", 2.7f),
                   new CollectStudent("Carol", 3.5f))
               .collect(
                    Collectors
                         .summarizingDouble(CollectStudent::getGpa));
//    System.out.println(gpaStats);
  }
}
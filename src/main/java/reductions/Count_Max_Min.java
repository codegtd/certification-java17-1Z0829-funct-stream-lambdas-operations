package reductions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Count_Max_Min {
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1, 2);

    long cnt = list.stream().count();

    Optional<Integer> max =
         list.stream()
             .max(Comparator.naturalOrder());

    Integer maxInt = max.get(); // no allow Empty


    Optional<Integer> min =
         list.stream()
             .min(Comparator.naturalOrder());

    Integer minInt = min.orElse(-1); // allow Empty

 show("Count:"+cnt+"\nMax:"+maxInt+"\nMin:"+minInt);

  }

  private static void show(String text) {

    System.out.println(text);
  }
}
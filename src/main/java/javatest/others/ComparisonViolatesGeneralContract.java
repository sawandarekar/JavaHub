package javatest.others;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

public class ComparisonViolatesGeneralContract {

  public static void main(String[] args) {
    Entity e1 = Entity.builder().id(2).build();
    Entity e2 = Entity.builder().id(3).build();
    Entity e3 = Entity.builder().id(-2).build();

    EntityByIdComparator comparator = new EntityByIdComparator();
    List<Entity> ls = Arrays.asList(e1, e2, e3);
    Collections.sort(ls, comparator);
//    Entity[] e = {e1, e2, e3};
//    Arrays.sort(e, comparator);
    System.out.println("sorted list:"+ls);
    //verifyTransitivity(comparator, ls);
  }
  public static <T> void verifyTransitivity(Comparator<T> comparator, Collection<T> elements) {
    for (T first : elements) {
      for (T second : elements) {
        int result1 = comparator.compare(first, second);
        int result2 = comparator.compare(second, first);
        if (result1 != -result2) {
          // Uncomment the following line to step through the failed case
          //comparator.compare(first, second);
          throw new AssertionError("compare(" + first + ", " + second + ") == " + result1 +
                                   " but swapping the parameters returns " + result2);
        }
      }
    }
    for (T first : elements) {
      for (T second : elements) {
        int firstGreaterThanSecond = comparator.compare(first, second);
        if (firstGreaterThanSecond <= 0)
          continue;
        for (T third : elements) {
          int secondGreaterThanThird = comparator.compare(second, third);
          if (secondGreaterThanThird <= 0)
            continue;
          int firstGreaterThanThird = comparator.compare(first, third);
          if (firstGreaterThanThird <= 0) {
            // Uncomment the following line to step through the failed case
            //comparator.compare(first, third);
            throw new AssertionError("compare(" + first + ", " + second + ") > 0, " +
                                     "compare(" + second + ", " + third + ") > 0, but compare(" + first + ", " + third + ") == " +
                                     firstGreaterThanThird);
          }
        }
      }
    }
  }
}

@Builder
@Getter
class Entity{
  long id;

  @Override
  public String toString() {
    return "Entity{" + "id=" + id + "}";
  }
}

class EntityByIdComparator implements Comparator<Entity> {
  public int compare(Entity o1, Entity o2) {
    long idDiff;

    // Perform an identifier comparison.
    idDiff = o1.getId() - o2.getId();
    System.out.println("o1_id:"+o1.getId()+" o2_id: "+o2.getId()+" idDiff:"+idDiff);
    if (idDiff > 0) {
      return 1;
    } else if (idDiff < 0) {
      return -1;
    } else {
      return 0;
    }
  }
}

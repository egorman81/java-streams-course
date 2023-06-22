package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  private final Predicate<Car> yellowCar = car -> car.getColor().equalsIgnoreCase("yellow");

  @Test
  public void count() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    long count = cars.stream()
        .filter(yellowCar)
        .mapToDouble(Car::getPrice)
        .count();

    System.out.println(count);

  }

  @Test
  public void min() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    double min = cars.stream()
        .filter(yellowCar)
        .mapToDouble(Car::getPrice)
        .min()
        .orElse(0);


    System.out.println(min);
  }

  @Test
  public void max() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    double max = cars.stream()
        .filter(yellowCar)
        .mapToDouble(Car::getPrice)
        .max()
        .orElse(0);

    System.out.println(max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();

    double average = cars.stream()
        .filter(yellowCar)
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);

    System.out.println(average);

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}
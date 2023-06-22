package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  public static final Predicate<Car> CAR_PREDICATE = car -> car.getPrice() < 20000;

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    List<Car> filteredCars = cars.stream()
        .filter(CAR_PREDICATE)
        .collect(Collectors.toList());

    filteredCars.forEach(System.out::println);
    System.out.println(filteredCars.size());

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> dtoPeople = people.stream()
        .map(PersonDTO::new)
        .collect(Collectors.toList());

    assertThat(dtoPeople).hasSize(1000);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    List<Car> cars = MockData.getCars();

    OptionalDouble average = cars.stream()
        .mapToDouble(Car::getPrice)
        .average();

    System.out.println(average.getAsDouble());


  }

  @Test
  public void test() throws Exception {

  }
}




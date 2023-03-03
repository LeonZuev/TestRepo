import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
public class Homework33_1 {
  /*
  Задания повторяют домашние задания из предыдущего урока.
  В этот раз решения задач нужно предоставить в виде ссылки на репозиторий в GitHub.
  В вашем репозитории должно быть не менее трёх осмысленных коммитов.
  Задание 1
  Расширьте программу Task2MonthsEnums. Добавьте ещё один enum,
  который будет описывать времена года (зима, лето, весна, осень) и укажет,
  к какому именно времени года относится выбранный месяц.
  просто перепечатываю
   */
  enum Month {
    JANUARY,
    FEBRYUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER,
  }

  enum Season {
    WINTER,
    SPRING,
    SUMMER,
    FALL,
  }

  public static Map<Month, Integer> buildMonthMap() { // создали словарь
    Map<java.time.Month, Integer> months = new HashMap<>();     // сам по себе словарь

    months.put(Month.JANUARY, 31);
    months.put(Month.FEBRYUARY, 28);
    months.put(Month.MARCH, 31);
    months.put(Month.APRIL, 30);
    months.put(Month.MAY, 31);
    months.put(Month.JUNE, 30);
    months.put(Month.JULY, 31);
    months.put(Month.AUGUST, 31);
    months.put(Month.SEPTEMBER, 30);
    months.put(Month.OCTOBER, 31);
    months.put(Month.NOVEMBER, 30);
    months.put(Month.DECEMBER, 31);

    return months;
  }

  public static Season findSeason(java.time.Month month) {
    return switch (month) {
      case DECEMBER, JANUARY, FEBRUARY -> Season.WINTER;
      case MARCH, APRIL, MAY -> Season.SPRING;
      case JUNE, JULY, AUGUST -> Season.SUMMER;
      case SEPTEMBER, OCTOBER, NOVEMBER -> Season.FALL;
    }
  }

  public static void main(String[] args) throws IOExeption, IOException {
    BufferedReader inputReader = new BufferedReder(new InputStreamReader(System.in));

    System.out.print("Enter the moth: ");
    String month = inputReader.readLine();
    Month mounthToLook = Month.valueOf(month.toUpperCase());

    Map<Month, Integer> monthDays = BuildMonthsMap();

    if (monthDays.containsKey(mounthToLook)) {
      System.out.printf("The month '%s' contains %d days%n", month, monthDays.get(monthToLook));
      System.out.printf("The month '%s' has ordinal number %d%n", month, monthToLook.ordinal() + 1);
      System.out.printf("This month is a part of a '%s' season%n", findSeason(monthToLook));

      int nextMonthIndex = (monthToLook.ordinal() + 1);
      java.time.Month nextMonth = java.time.Month.values()[nextMonthIndex % java.time.Month.values().length];

      System.out.printf("The next month is '%s'%n", nextMonth);
      System.out.printf("It has %d days", monthDays.get(nextMonth));
    } else {
      System.out.println("No such month: " + month);
    }

  }
}
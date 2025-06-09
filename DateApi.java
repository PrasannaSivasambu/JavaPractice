import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DateApi {

    public static void main(String[] args) {

        // Finding Difference Between Two Dates

        LocalDate start = LocalDate.of(2024, 2, 1);
        LocalDate end = LocalDate.of(2025, 5, 13);

        Period period = Period.between(start, end);
        

        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());

        //Working with Time Zones

        ZonedDateTime zonedNow = ZonedDateTime.now();  
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println("Current Zone: " + zonedNow);
        System.out.println("New York Time: " + newYorkTime);

        //Formatting and Parsing Dates

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println("Formatted DateTime: " + formattedDateTime);

        //Adding and Subtracting Days, Months, Years

        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);  
        LocalDate lastMonth = today.minusMonths(1);  
        LocalDate nextYear = today.plusYears(1);

        // nextWeek=today.plusDays(2);

        System.out.println("Today: " + today);
        System.out.println("Next Week: " + nextWeek);
        System.out.println("Last Month: " + lastMonth);
        System.out.println("Next Year: " + nextYear);


        //Creating a Specific Date and Time

        LocalDate specificDate = LocalDate.of(2025, 4, 1);
        LocalTime specificTime = LocalTime.of(14, 30, 0);
        LocalDateTime specificDateTime = LocalDateTime.of(2025, 4, 1, 14, 30);

        System.out.println("Specific Date: " + specificDate);
        System.out.println("Specific Time: " + specificTime);
        System.out.println("Specific DateTime: " + specificDateTime);

        //Getting Current Date and Time

        LocalDate date = LocalDate.now();       // 2025-04-01
        LocalTime time = LocalTime.now();       // 12:30:45.123456
        LocalDateTime dateTime = LocalDateTime.now(); // 2025-04-01T12:30:45.123456
        
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("DateTime: " + dateTime);

        String s="abbc";
        System.out.println( s.chars().mapToObj(Character::toString).collect(Collectors.joining("")) );


         String input = "The price is 45 and discount is 10";
        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Found number: " + matcher.group());
        }
    }
    
}

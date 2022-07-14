
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Arrays;
import java.util.List;


public class test {
    public static void main(String[] args) {

        LocalTime[] workingHours = {
                LocalTime.of(8, 0),
                LocalTime.of(9, 0),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0),
                LocalTime.of(12, 0),
                LocalTime.of(13, 0),
                LocalTime.of(14, 0),
                LocalTime.of(15, 0),
                LocalTime.of(16, 0),
                LocalTime.of(17, 0),
                LocalTime.of(18, 0),
        };

        LocalDate date1 = LocalDate.of(2022, 7, 14);
        LocalTime startTime1 = LocalTime.of(10, 0);
        LocalTime endTime1 = LocalTime.of(12, 0);
        Appointment appointment1 = new Appointment(date1, startTime1, endTime1);

        LocalDate date2 = LocalDate.of(2022, 7, 14);
        LocalTime startTime2 = LocalTime.of(13, 0);
        LocalTime endTime2 = LocalTime.of(15, 0);
        Appointment appointment2 = new Appointment(date2, startTime2, endTime2);

        List<Appointment> appointments = Arrays.asList(appointment1, appointment2);

        Arrays.stream(workingHours)
                .filter(workingHour -> appointments.stream()
                        .noneMatch(appointment -> isInAppointment(workingHour, appointment)))
                .forEach(System.out::println);




    }

    private static boolean isInAppointment(LocalTime workingHour, Appointment appointment) {
       return workingHour.getHour() >= appointment.getStartTime().getHour() - 1 && workingHour.getHour() <= appointment.getEndTime().getHour();
    }
}



















































/*
 LocalDate date = LocalDate.parse("2015-02-20");
 LocalTime time = LocalTime.parse("06:30");
 */


//        //Bulgarian time zone
//        LocalTime time = LocalTime.now(ZoneId.of("GMT+3"));
//
//
//
//        LocalDate date1 = LocalDate.parse("2022-07-14");
//        LocalDate date2 = LocalDate.parse("2022-07-14");
//        LocalDate date3 = LocalDate.parse("2022-07-14");
//
//        LocalDate date4 = LocalDate.parse("2022-07-13");
//        LocalDate date5 = LocalDate.parse("2022-07-17");
//        LocalDate date6 = LocalDate.parse("2022-07-19");
//
//        List<LocalDate> dates = List.of(date1, date2, date3, date4, date5, date6);
//
//        dates.stream()
//                .filter(date -> date.getDayOfMonth() == LocalDate.now().getDayOfMonth())
//                .forEach(System.out::println);
//
//
//        System.out.println(date1.equals(date2));





 /*       Duration dur = Duration.between(
                java.time.LocalTime.now(),
                java.time.LocalTime.now().plusHours(1).plusMinutes(30)
        );

        System.out.println(dur.getSeconds());*/
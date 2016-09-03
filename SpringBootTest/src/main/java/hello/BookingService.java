package hello;

import java.time.Clock;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newTreeMap;

public class BookingService {
    Map<String, Appointment> appointments;
    List<Preference> preferences;
    Clock clock;
    private PreferenceRatingSystem ratingSystem;

    public BookingService(Map<String, Appointment> appointments, List<Preference> preferences, Clock clock, PreferenceRatingSystem ratingSystem) {
        this.appointments = appointments;
        this.preferences = preferences;
        this.clock = clock;
        this.ratingSystem = ratingSystem;
    }

    public void bookAppointment(Appointment appointment) {
            appointments.put(appointment.getAppointmentId(), appointment);
    }

    public void addPreference(Preference preference) {
        preferences.add(preference);
    }

    public List<Preference> fillTimeSlot(Instant startTime, Instant endTime) {
        TreeMap<Integer, Preference> ratings = newTreeMap();
        preferences.stream().forEach(preference -> {
            Integer rating = ratingSystem.rate(appointments.get(preference.getAppointmentId()), preference);
            ratings.put(rating, preference);
        });
        List<Preference> fillers = newArrayList();
        Map.Entry<Integer, Preference> highest = ratings.lastEntry();
        fillers.add(highest.getValue());

        return fillers;
    }



}

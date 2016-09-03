/*
 * Copyright Omnifone Limited 2009-2016. All rights reserved.
 * This source code includes confidential proprietary information.
 */
package feature;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hello.Appointment;
import hello.BookingService;
import hello.Preference;
import hello.PreferenceRatingSystem;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PromotionsSteps {
    private BookingService bookingService;
    private Clock clock;
    private List<Preference> fillResult;

    public PromotionsSteps() {
        clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        bookingService = new BookingService(newHashMap(), newArrayList(), clock, new PreferenceRatingSystem());
    }

    @Given("^the following users exist:$")
    public void The_following_users_exist(DataTable data) {
        System.out.format("Cukes: %n\n", data);
    }

    @Given("^the following preferences exist:$")
    public void The_following_preferences_exist(DataTable data) {

        List<List<String>> lists = data.asLists(String.class);

        for (int i = 1; i < lists.size(); i++) {
            List<String> cells = lists.get(i);
            String preferenceId = cells.get(0);
            String userId = cells.get(1);
            Instant booking = Instant.parse(cells.get(2));
            Instant start = Instant.parse(cells.get(3));
            Instant end = Instant.parse(cells.get(4));
            String appointmentId = cells.get(5);

            bookingService.addPreference(new Preference(preferenceId, booking, start, end, userId, appointmentId));
        }

    }

    @Given("^the following appointments exist:$")
    public void the_following_appointments_exist(DataTable data) throws Throwable {
        List<List<String>> lists = data.asLists(String.class);

        for (int i = 1; i < lists.size(); i++) {
            List<String> cells = lists.get(i);
            String appointmentId = cells.get(0);
            String customerId = cells.get(1);
            Instant booking = Instant.parse(cells.get(2));
            Instant start = Instant.parse(cells.get(3));
            Instant end = Instant.parse(cells.get(4));
            Integer promotions = Integer.parseInt(cells.get(5));

            bookingService.bookAppointment(new Appointment(appointmentId, booking, start, end, customerId, promotions));
        }
    }

    @When("^we try to fill the empty slot starting at \"([^\"]*)\" and ending at \"([^\"]*)\"$")
    public void we_try_to_fill_the_empty_slot_starting_at_and_ending_at(String arg1, String arg2) throws Throwable {
        BookingService bookingService = this.bookingService;
        fillResult = bookingService.fillTimeSlot(Instant.parse(arg1), Instant.parse(arg2));
    }

    @Then("^preferenceId \"([^\"]*)\"  for \"([^\"]*)\" should be chosen to fill the slot$")
    public void preferenceid_for_should_be_chosen_to_fill_the_slot(String preferenceId, String userId) throws Throwable {
        Preference preference = fillResult.get(0);
        assertThat(preference.getPreferenceId(), equalTo(preferenceId));
        assertThat(preference.getCustomerId(), equalTo(userId));
    }
}

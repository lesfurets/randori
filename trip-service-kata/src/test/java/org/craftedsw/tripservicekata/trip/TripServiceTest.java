package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TripServiceTest {


    private User LOGGED_USER = new User();

    @Test(expected = UserNotLoggedInException.class)
    public void should_throw_if_user_not_logged_in() throws Exception {
        new TestableTripService(null).getTripsByUser(new User());
    }

    @Test
    public void should_return_empty_if_no_friends() {
        User userWithNorFriends = new User();

        TestableTripService tripService = new TestableTripService(LOGGED_USER);


        List<Trip> trips = tripService.getTripsByUser(userWithNorFriends);

        assertTrue(trips.isEmpty());
    }

    @Test
    public void should_return_empty_if_loggued_user_is_not_friend() {
        User userThatHasOtherFriends = new User();
        userThatHasOtherFriends.addFriend(new User());

        TestableTripService tripService = new TestableTripService(LOGGED_USER);

        List<Trip> trips = tripService.getTripsByUser(userThatHasOtherFriends);
        assertTrue(trips.isEmpty());
    }

    @Test
    public void should_return_trips_if_loggeduser_is_friend() {
        User userWithLoggedUserAsFriend = new User();
        userWithLoggedUserAsFriend.addFriend(LOGGED_USER);

        TestableTripService tripService = new TestableTripService(LOGGED_USER);

        List<Trip> trips = tripService.getTripsByUser(userWithLoggedUserAsFriend);

        assertFalse(trips.isEmpty());
    }

    private static class TestableTripService extends TripService {
        private final User loggedInUser;

        private TestableTripService(User loggedInUser) {
            this.loggedInUser = loggedInUser;
        }

        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }

        @Override
        protected List<Trip> findTripsByUser(User user) {
            return Collections.singletonList(new Trip());
        }
    }
}
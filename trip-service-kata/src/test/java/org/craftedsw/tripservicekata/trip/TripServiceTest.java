package org.craftedsw.tripservicekata.trip;

import java.util.Arrays;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.*;

public class TripServiceTest {

    public TripService buildTripService(final User loggedUser) {
        TripDAO tripDAO = new TripDAO() {
            @Override
            public List<Trip> findTripsByUserNotStatic(User user) {
                return Arrays.asList(new Trip());
            }
        };

        return new TripService(tripDAO) {
            @Override
            protected User getLoggedUser() {
                return loggedUser;
            }
        };
    }

    @Test(expected = UserNotLoggedInException.class)
    public void shouldThrowExceptionWhenNotLogged() {
        buildTripService(null).getTripsByUser(null);
    }

    @Test
    public void shouldReturnEmptyTripListWhenNotFriend() {
        User loggedUser = new User();
        User user = new User();
        user.addFriend(new User());
        List<Trip> tripsByUser = buildTripService(loggedUser).getTripsByUser(user);
        Assert.assertTrue(tripsByUser.isEmpty());
    }

    @Test
    public void shouldReturnTripListWhenFriend() {
        User loggedUser = new User();
        User friend = new User();
        friend.addFriend(loggedUser);
        List<Trip> tripsByUser = buildTripService(loggedUser).getTripsByUser(friend);
        Assert.assertFalse(tripsByUser.isEmpty());
    }
}

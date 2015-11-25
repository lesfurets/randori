package org.craftedsw.tripservicekata.trip;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Assert;
import org.junit.Test;

public class TripServiceTest {

    @Test(expected = CollaboratorCallException.class)
    public void shouldReturnCollaboratorCallException() {
        TripService tripService = new TripService();
        List<Trip> trips = tripService.getTripsByUser(null);
    }


    @Test(expected = UserNotLoggedInException.class)
    public void should_return_UserNotLoggedException_when_not_logged() {
        TripService tripService = getTripService(null, null);
        List<Trip> trips = tripService.getTripsByUser(new User());
    }
    
    
    @Test
    public void should_get_TripList_for_logged_user() {
        User u = new User();
        TripService tripService = getTripService(u, null);
        List<Trip> trips = tripService.getTripsByUser(new User());
        assertFalse(trips == null);
    }
    
    @Test
    public void should_return_tripList_for_friend_user() {
        User u = new User();
        ArrayList<Trip> mockTripList = new ArrayList<Trip>();
        TripService tripService = getTripService(u, mockTripList);
        User friend = new User();
        friend.addFriend(u);
        List<Trip> trips = tripService.getTripsByUser(friend);
        assertTrue(trips == mockTripList);
    }

    @Test
    public void should_return_empty_for_not_friend_user() {
        User u = new User();
        ArrayList<Trip> mockTripList = new ArrayList<Trip>();
        TripService tripService = getTripService(new User(), mockTripList);
        User friend = new User();
        friend.addFriend(u);
        List<Trip> trips = tripService.getTripsByUser(friend);
        assertTrue(trips.isEmpty());
    }
    
    protected TripService getTripService(final User user,
                    final List<Trip> tripList) {
        return new TripService() {
            @Override
            protected User getLoggedUser() {
                return user;
            }

            @Override
            protected List<Trip> getTripsListByUser(User user) {
                return tripList;
            }
        };
    }
}

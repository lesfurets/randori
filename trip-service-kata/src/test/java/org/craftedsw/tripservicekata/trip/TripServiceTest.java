package org.craftedsw.tripservicekata.trip;

import static java.util.Collections.emptyList;
import java.util.ArrayList;
import java.util.List;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Assert;
import org.junit.Test;

public class TripServiceTest {

  private final TripDAO tripDao = new TripDAO();

  @Test(expected = UserNotLoggedInException.class)
  public void should_raise_UserNotLoggedInException_when_user_is_not_logged() {
    // Given
    User user = new User();
    TripService tripService = new TripService(tripDao);

    // When
    tripService.getTripsByUser(user, null);
    // Then

  }

  @Test
  public void should_return_empty_list_if_user_doesnt_have_friend() {
    // Given
    User user = new User();
    TripService tripService = new TripService(tripDao);
    // When
    List<Trip> tripsByUser = tripService.getTripsByUser(user, new User());

    // Then
    Assert.assertEquals(emptyList(), tripsByUser);
  }

  @Test
  public void should_return_empty_list_if_they_re_not_friends() {
    // Given
    User user = new User();
    user.addFriend(new User());
    TripService tripService = new TripService(tripDao);

    // When
    List<Trip> tripsByUser = tripService.getTripsByUser(user, new User());

    // Then
    Assert.assertEquals(emptyList(), tripsByUser);
  }

  @Test
  public void should_return_trips_when_loggedUser_is_friend_of_user() {
    // Given
    User user = new User();
    final User loggedUser = new User();
    user.addFriend(loggedUser);

    final List<Trip> expectedTrips = new ArrayList<Trip>();
    expectedTrips.add(new Trip());

    final TripDAO tripDao = new TripDAO() {
      @Override
      public List<Trip> findTrips(User user) {
        return expectedTrips;
      }
    };
    TripService tripService = new TripService(tripDao);

    // When
    List<Trip> tripsByUser = tripService.getTripsByUser(user, loggedUser);

    // Then
    Assert.assertEquals(expectedTrips, tripsByUser);
  }
}

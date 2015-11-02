package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import java.util.Collections;
import java.util.List;

public class TripService {
  public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
    User loggedUser = getLoggedUser();
    if (loggedUser == null) {
      throw new UserNotLoggedInException();
    }

    if (!user.isFriendOf(loggedUser)) {
      return Collections.emptyList();
    }

    return findTripsByUser(user);
  }

  protected List<Trip> findTripsByUser(User user) {
    return TripDAO.findTripsByUser(user);
  }

  protected User getLoggedUser() {
    return UserSession.getInstance().getLoggedUser();
  }

}

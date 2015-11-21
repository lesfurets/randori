package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;

public class TripService {

  private final TripDAO tripDao;

  public TripService(TripDAO tripDao) {
    this.tripDao = tripDao;
  }

  public List<Trip>getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
    if (loggedUser == null) {
      throw new UserNotLoggedInException();
    }
    if (user.isFriend(loggedUser)) {
      return tripDao.findTrips(user);
    }
    return new ArrayList<Trip>();
  }

}

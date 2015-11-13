package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {
  private final TripDAO tripDao;

  public TripService(TripDAO tripDao) {
    this.tripDao = tripDao;
  }

  public TripService() {
    this(new TripDAO());
  }

  public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
    User loggedUser = getLoggedUser();
    if (loggedUser == null) {
      throw new UserNotLoggedInException();
    }
    List<Trip> tripList = new ArrayList<Trip>();
    if (user.isFriendWith(loggedUser)) {
      tripList = getTripsByUserDao(user);
    }
    return tripList;
  }

  protected List<Trip> getTripsByUserDao(User user) {
    return tripDao.findTripsByUserNotStatic(user);
  }

  protected User getLoggedUser() {
    return UserSession.getInstance().getLoggedUser();
  }

}

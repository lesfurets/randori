package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.*;

public class TripService {
    private TripDAOImpl tripDAO;
    private UserSessionFacade userSessionFacade;

    public TripService() {
        this(new TripDAOImpl(), new UserSessionFacade());
    }

    public TripService(TripDAOImpl tripDAO, UserSessionFacade userSessionFacade) {
        this.tripDAO = tripDAO;
        this.userSessionFacade = userSessionFacade;
    }

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        User loggedUser = getLoggedUser();
        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
        if (user.getFriends().contains(loggedUser)) {
            return getTripsListByUser(user);
        }
        return new ArrayList<Trip>();
    }

    protected List<Trip> getTripsListByUser(User user) {
        return tripDAO.findTripsByUser(user);
    }

    protected User getLoggedUser() {
        return userSessionFacade.getLoggedUser();
    }

}

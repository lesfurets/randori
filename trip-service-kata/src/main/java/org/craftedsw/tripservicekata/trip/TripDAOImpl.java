/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package org.craftedsw.tripservicekata.trip;

import java.util.List;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;

public class TripDAOImpl {

    public List<Trip> findTripsByUser(User user) {
        return TripDAO.findTripsByUser(user);
    }

}
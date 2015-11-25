/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package org.craftedsw.tripservicekata.user;

public class UserSessionFacade {
    UserSessionSupplier supplier = new UserSessionSupplier();

    public User getLoggedUser() {
        return supplier.supply().getLoggedUser();
    }
}

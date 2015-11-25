/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package org.craftedsw.tripservicekata.user;

public class UserSessionSupplier {
    public UserSession supply() {
        return UserSession.getInstance();
    }
}

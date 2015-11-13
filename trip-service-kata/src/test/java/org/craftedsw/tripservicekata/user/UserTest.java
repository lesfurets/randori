package org.craftedsw.tripservicekata.user;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void shouldReturnDetectFriends() {
        User harry = new User();
        User ron = new User();

        ron.addFriend(harry);

        Assert.assertTrue(ron.isFriendWith(harry));
        Assert.assertFalse(harry.isFriendWith(ron));
    }

    @Test
    public void shouldReturnDetectNoFriends() {
        User harry = new User();
        User ron = new User();

        Assert.assertFalse(ron.isFriendWith(harry));
    }
}

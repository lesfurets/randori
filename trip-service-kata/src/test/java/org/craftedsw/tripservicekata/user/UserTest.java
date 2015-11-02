package org.craftedsw.tripservicekata.user;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {
    @Test
    public void should_return_true_if_user_is_friend() throws Exception {
        User user = new User();
        User friend = new User();
        user.addFriend(friend);

        boolean isFriend = user.isFriendOf(friend);

        assertTrue(isFriend);
    }
    @Test
    public void should_return_true_if_user_is_not_friend() throws Exception {
        User user = new User();
        User foe = new User();

        boolean isFriend = user.isFriendOf(foe);

        assertFalse(isFriend);
    }


}
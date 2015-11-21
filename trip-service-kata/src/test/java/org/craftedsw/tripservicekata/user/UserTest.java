package org.craftedsw.tripservicekata.user;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

  @Test
  public void should_return_true_when_friends() {
    // Given
    User user = new User();
    User friend=new User();
    user.addFriend(friend);

    // When
    boolean isFriend=user.isFriend(friend);

    // Then
    Assert.assertTrue(isFriend);
  }

  @Test
  public void should_return_false_when_not_friends() {
    // Given
    User user = new User();
    User notFriend=new User();

    // When
    boolean isFriend=user.isFriend(notFriend);

    // Then
    Assert.assertFalse(isFriend);
  }
}

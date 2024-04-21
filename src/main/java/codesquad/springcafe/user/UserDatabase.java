package codesquad.springcafe.user;

import java.util.List;

public interface UserDatabase {

     void addUser(User user);

     List<User> getUserList();

     User getUser(String userId);

     void updateUser(User user);

     boolean isExistUser(String userId);
}

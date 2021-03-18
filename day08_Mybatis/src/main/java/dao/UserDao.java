package dao;

import pojo.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/18 21:26
 * @Version 1.0
 */
public interface UserDao {

    List<User> getUserList();

    User getUserById(int id);

}

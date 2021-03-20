package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

/**
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/18 21:38
 * @Version 1.0
 */
public class UserDaoTest {

    @Test
    public void test() {

        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行SQL
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    @Test
    public void test1() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User userById = userDao.getUserById(2);

        System.out.println(userById);

        sqlSession.close();

    }

    @Test
    public void test2() {

        //增删改要提交事务
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User(4, "Nathan", "1224442");

        userDao.addUser(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test3() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User(4, "Nathan", "8888888");

        userDao.updateUser(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test4() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        userDao.deleteUserById(4);

        sqlSession.commit();
        sqlSession.close();

    }

}

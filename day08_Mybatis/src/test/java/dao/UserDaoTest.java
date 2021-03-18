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

}

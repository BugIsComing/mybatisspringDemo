package com.lc.client;

import com.lc.dao.UserDao;
import com.lc.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

//        User user = new User();
//        final int index = 1001;
//        for(int i=index;i<=index + 10;i++){
//            user.setName("LC");
//            user.setAge(i);
//            userDao.saveUser(user);
//        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name","lc");
        //params.put("age",2);
        List<User> userList = userDao.getUserByParam(params);
        for (User ur : userList){
            System.out.println(ur.toString());
        }
    }
}

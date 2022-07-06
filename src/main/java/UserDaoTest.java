import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) {

//        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        try {
            dao.add(new User("asd", "ssoonan", "1234"));
            User user = dao.get("asd");
            System.out.println(user.name);
//            CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
//            System.out.println("count: " + ccm.counter);
            dao.delete("asd");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// DaoFactory에는 여전히 new가 있어야 되긴 함. but Bean으로 되어있기에 알아서 만들고 재사용됨.

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new MyConnectionMaker();
    }
}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

// DaoFactory에는 여전히 new가 있어야 되긴 함. but Bean으로 되어있기에 알아서 만들고 재사용됨.

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

    @Bean
    public DataSource dataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:db/db.sqlite");
        return dataSource;
    }
}

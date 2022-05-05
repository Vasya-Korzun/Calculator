package by.korzun.calculator.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import by.korzun.calculator.entity.User;
import by.korzun.calculator.storage.connection.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    Logger logger = LoggerFactory.getLogger(UserDao.class);
    private final DataBaseConnection connection;

    public UserDao() {
        this.connection = new DataBaseConnection();
    }

    public boolean userExist(User user) {
        try{
            PreparedStatement ps = connection.getPreparedStatement("select * from users where login = ? and password = ?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet result = ps.executeQuery();
            return result.next();
        }catch (SQLException ex){
            logger.error(ex.getMessage());
            return true;
        }
    }

    public boolean saveUser(User user) {
        try {
            if (!userExist(user)) {
                PreparedStatement ps = connection.getPreparedStatement("insert into users(login, password) values (?, ?)");
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.execute();
            }else {
                return false;
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            return false;
        }
        return true;
    }
}

package DB.DAO;

import java.sql.SQLException;

public interface UserLoginDAO {
    public int authClient(String login, String password) throws SQLException;
}

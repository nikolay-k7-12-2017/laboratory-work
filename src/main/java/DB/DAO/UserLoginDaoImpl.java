package DB.DAO;


import DB.POJO.UserLogin;
import DB.connections.ConnectionManager;
import DB.connections.ConnectionManagerPostgeImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserLoginDaoImpl implements UserLoginDAO {
    private static ConnectionManager connectionManager =
            ConnectionManagerPostgeImpl.getInstance();

    @Override
    public int authClient(String login, String password) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id,id_personal,login,password " +
                "FROM public.user_login WHERE login = ? AND password = ?"
        );
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet set = statement.executeQuery();
        List<UserLogin> userLoginList = new ArrayList<>();
        while (set.next()) {
            UserLogin userLogin = new UserLogin(
                    set.getInt("id"),
                    set.getInt("id_personal"),
                    set.getString("login"),
                    set.getString("password")

            );
            userLoginList.add(userLogin);
        }
        connection.close();

        int f = 0;
        for (int i = 0; i < userLoginList.size(); i++) {
            if (userLoginList.get(i).getLogin().equals(login)
                    && userLoginList.get(i).getPassword().equals(password)) {
                f = userLoginList.get(i).getId_personal();
            }
        }
        return f;
    }

    public static void main(String[] args) throws SQLException {
        UserLoginDAO userLoginDAO = new UserLoginDaoImpl();
        System.out.println(userLoginDAO.authClient("kaz", "kaz"));

    }
}
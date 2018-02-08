package DB.DAO;


import DB.connections.ConnectionManager;
import DB.connections.ConnectionManagerPostgeImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserPersonalDaoImpl implements UserPersonalDAO {
    private static ConnectionManager connectionManager =
            ConnectionManagerPostgeImpl.getInstance();


    public void regClient(String f_name, String l_name,
                          String s_name, Date bir, String se, String pr) {
        Connection connection = connectionManager.getConnection();

        try {
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO public.user_personal (first_name,last_name,second_name," +
                    "birthday,sex,proffesion) VALUES(?,?,?,?,?,?);"
            );
            preparedStatement.setString(1, f_name);
            preparedStatement.setString(2,l_name);
            preparedStatement.setString(3,s_name);
            preparedStatement.setDate(4, (java.sql.Date) bir);
            preparedStatement.setString(5,se);
            preparedStatement.setString(6,pr);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

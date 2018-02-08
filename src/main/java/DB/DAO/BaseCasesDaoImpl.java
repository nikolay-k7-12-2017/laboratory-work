package DB.DAO;

import DB.POJO.BaseCases;
import DB.POJO.UserLogin;
import DB.connections.ConnectionManager;
import DB.connections.ConnectionManagerPostgeImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class BaseCasesDaoImpl implements BaseCasesDAO {
    private static ConnectionManager connectionManager =
            ConnectionManagerPostgeImpl.getInstance();

    @Override
    public void writeData(String string, long date1, int id1) {
        Connection connection = connectionManager.getConnection();
        try {
            java.sql.Date aaaa= new java.sql.Date(date1);
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO public.base_cases (id,my_affairs,data_plane" +
                    ") VALUES(?,?,?);"
            );
            preparedStatement.setInt(1, id1);
            preparedStatement.setString(2, string);
            preparedStatement.setDate(3,  aaaa);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<BaseCases> readData(int id1) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id,my_affairs,data_plane " +
                "FROM public.base_cases WHERE ?= id "
        );
        statement.setInt(1, id1);
        ResultSet set = statement.executeQuery();
        List<BaseCases> listBase = new ArrayList<>();
        while (set.next()) {
            BaseCases baseCases = new BaseCases(
                    set.getInt("id"),
                    set.getString("my_affairs"),
                    set.getDate("data_plane")

            );
            listBase.add(baseCases);
        }
        connection.close();
        return listBase;
    }

    public static void main(String[] args) {
        BaseCasesDaoImpl baseCasesDao=new BaseCasesDaoImpl();
       // GregorianCalendar calendar=new GregorianCalendar(2018,01,20);
       /* long ddd = calendar.getTimeInMillis();
        java.sql.Date aaaa= new java.sql.Date(ddd);
        System.out.println(ddd);
        baseCasesDao.writeData("gdgdgdgdgdgdgdg", ddd,1);*/
        try {
            baseCasesDao.readData(1);
            System.out.println(baseCasesDao.readData(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package DB.POJO;

import java.util.Date;

public class BaseCases {
    private int id;
    private int id_drop;
    private String my_affairs;
    private Date data_plane;

    public BaseCases(int id, int id_drop, String my_affairs, Date data_plane) {
        this.id = id;
        this.id_drop = id_drop;
        this.my_affairs = my_affairs;
        this.data_plane = data_plane;
    }
    public BaseCases(){}

    public BaseCases(int id, String my_affairs, Date data_plane) {
        this.id = id;
        this.my_affairs = my_affairs;
        this.data_plane = data_plane;
    }

    @Override
    public String toString() {
        return "BaseCases{" +
                "id=" + id +
                ", id_drop=" + id_drop +
                ", my_affairs='" + my_affairs + '\'' +
                ", data_plane=" + data_plane +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_drop() {
        return id_drop;
    }

    public void setId_drop(int id_drop) {
        this.id_drop = id_drop;
    }

    public String getMy_affairs() {
        return my_affairs;
    }

    public void setMy_affairs(String my_affairs) {
        this.my_affairs = my_affairs;
    }

    public Date getData_plane() {
        return data_plane;
    }

    public void setData_plane(Date data_plane) {
        this.data_plane = data_plane;
    }
}

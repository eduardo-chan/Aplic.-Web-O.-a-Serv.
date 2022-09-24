package model;

import utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser {

    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;


    public List<BeanUser> showDatos() {
        List<BeanUser> users = new ArrayList<>();
        BeanUser user = null;




        try {
            conn = new MySQLConnection().getConnection();
            pstm = conn.prepareStatement("SELECT * FROM datos");
            rs = pstm.executeQuery();
            while (rs.next()) {
                user = new BeanUser();
                user.setId(rs.getLong("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido_p(rs.getString("apellido_p"));
                user.setApellido_m(rs.getString("apellido_m"));
                user.setSexo(rs.getString("sexo"));
                user.setEstado_nac(rs.getString("estado_nac"));
                user.setApellido_p(rs.getString("fecha_nac"));
                user.setCurp(rs.getString("curp"));
                users.add(user); //guardar

                /*System.out.format("%s, %s, %s, %s, %s, %s, %s", user.getCurp().toString(), user.getNombre(),
                        user.getApellido_p(), user.getApellido_m(), user.getSexo(), user.getEstado_nac(),
                        user.getFecha_nac());*/
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error showDatos", e);
        } finally {
            closeConnection();
        }
        return users;
    }


    public boolean saveDatos(BeanUser user) {
        try {
            conn = new MySQLConnection().getConnection();
            pstm = conn.prepareStatement("INSERT INTO datos (nombre, apellido_p, apellido_m, sexo, estado_nac, fecha_nac, curp)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");
            //pstm.setLong(1, user.getId());
            pstm.setString(1, user.getNombre());
            pstm.setString(2, user.getApellido_p());
            pstm.setString(3, user.getApellido_m());
            pstm.setString(4, user.getSexo());
            pstm.setString(5, user.getEstado_nac());
            pstm.setString(6, user.getFecha_nac());
            pstm.setString(7, user.getCurp().toString());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error saveUser", e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {

        }
    }

}


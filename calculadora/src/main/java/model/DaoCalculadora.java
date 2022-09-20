package model;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCalculadora {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;


    public String GET_OPERACIONES = "SELECT * FROM operations";

    public String INSERT_OPERACIONES = "INSERT INTO operaciones(type, first_number, second_number, result, created_at) VALUES (?,?,?,?,?)";



    public List<BeanCalculadora> showHistory(){
        List<BeanCalculadora> resultadosList = new ArrayList<>();
        BeanCalculadora resultados = null;
        try {
            conn = new MySQLConnection().getConnection();
            String query = GET_OPERACIONES;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while(rs.next()){
                resultados = new BeanCalculadora();
                resultados.setId(rs.getLong("id"));
                resultados.setType(rs.getString("type"));
                resultados.setFirst_number(rs.getDouble("first_number"));
                resultados.setSecond_number(rs.getDouble("second_number"));
                resultados.setCreated_at(rs.getDate("create_at"));
                resultados.setResult(rs.getDouble("result"));
                resultadosList.add(resultados);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalculadora.class.getName())
                    .log(Level.SEVERE, "Error en showHistory -> ", e);
        }finally {
            closeConnections();
        }
        return resultadosList;
    }
    public void closeConnections(){
        try{
            if (conn!= null){
                conn.close();
            }
            if (pstm!= null){
                pstm.close();
            }
            if (rs!= null){
                rs.close();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


}

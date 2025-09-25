package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class DB {
    private static Connection conn = null;

    //abre as propriedades do arquivo db.properties;
    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("src/db/db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch(IOException e){
            throw new DBException("Erro ao carregar db.properties: " + e.getMessage());
        }
    }

    //abre conexao com o database;
    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch(SQLException e){
                throw new DBException("Erro de conexão: " + e.getMessage());
            }
        }
        
        return conn;
    }

    //fecha a conexao com o database;
    public static void closeConnection(){
        if (conn != null){
            try{
                conn.close();
            } catch(SQLException e){
                throw new DBException("Erro ao fechar conexao: " + e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){
        if (st != null){
            try{
                st.close();
            } catch(SQLException e){
                throw new DBException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            } catch(SQLException e){
                throw new DBException(e.getMessage());
            }
        }
    }
}

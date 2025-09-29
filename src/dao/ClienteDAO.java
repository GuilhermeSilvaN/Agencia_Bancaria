package dao;

import entities.Cliente;
import model.EstadoCivil;
import service.Conta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import db.DB;

public class ClienteDAO {

    //inserir cliente
    public void inserir(Cliente cliente){
        String sql = "INSERT INTO Cliente (nome, cpf, dataNascimento, estadoCivil)"
            + " VALUES (?, ?, ?, ?)";
        
        try(Connection conn = DB.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCPF());
            stmt.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            stmt.setString(4, cliente.getStateCivil().name());

            stmt.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeErrorException(null, "Erro ao inserir cliente: " + e.getMessage());
        } 
    }

    //buscar por cpf;
    public Cliente buscarPorCpf(String cpf){
        String sql = "SELECT * FROM Cliente WHERE cpf = ?";

        try(Connection conn = DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                
                String estadoCivilStr = rs.getString("estadoCivil");
                cliente.setStateCivil(EstadoCivil.valueOf(estadoCivilStr.toUpperCase()));
            }

        } catch(SQLException e){
            throw new RuntimeErrorException(null, "Erro ao buscar por cpf" + e.getMessage());
        }

        return null;
    }

    //Listar todas as contas;
    public List<Conta> listarTodas(){
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM conta";

        try(Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet sr = stmt.executeQuery(sql);
        ){
            while(rs.next()){
                String tipo = 
            }

        } catch(SQLException e){
            throw new RuntimeException(null);
        }



        return contas;
    }
}

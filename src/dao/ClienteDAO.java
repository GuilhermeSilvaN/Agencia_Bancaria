package dao;

import entities.Cliente;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import model.EstadoCivil;
import model.TipoConta;
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
        String sql = "SELECT c.id AS conta_id, c.numeroConta, c.tipo, c.saldo, " +
            "cl.id AS cliente_id, cl.nome, cl.cpf, cl.dataNascimento, cl.estadoCivil " + 
            "FROM conta c INNER JOIN cliente cl ON c.cliente_id = cl.id";

        try(Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()){
                //MONTA CLIENTE;
                Cliente cliente = new Cliente(
                    rs.getInt("cliente_id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getDate("dataNascimento").toLocalDate(),
                    EstadoCivil.valueOf(rs.getString("estadoCivil".toUpperCase()))
                );

                //MONTA CONFORME TIPO;
                Conta conta = null;
                TipoConta tipoConta = TipoConta.valueOf(rs.getString("tipo").toUpperCase());
                
                if(tipoConta == TipoConta.CORRENTE){
                    conta = new ContaCorrente(rs.getInt("conta_id"),
                        TipoConta.CORRENTE,
                        rs.getString("numeroConta"),
                        rs.getDouble("saldo"),
                        cliente);

                } else if (tipoConta == TipoConta.POUPANCA){
                    conta = new ContaPoupanca(
                        rs.getInt("conta_id"),
                        TipoConta.POUPANCA,
                        rs.getString("numeroConta"),
                        rs.getDouble("saldo"),
                        cliente);
                }
                
                if(conta != null) contas.add(conta);

            }


        } catch(SQLException e){
            throw new RuntimeException("Error ao solicitar lista : " + e.getMessage());
        }

        return contas;
    }

}

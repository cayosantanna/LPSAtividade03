/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import factory.Persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.atividadesemana05.Secretaria;

/**
 *
 * @author cayo
 */
public class SecretariaDAO implements IDAO {

    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    

    public void save(Object obj){
        Secretaria secretaria = (Secretaria) obj;

        sql = " INSERT INTO "
                + " curso(nome, tipo, duracao, detalhes) "
                + " VALUES(?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, secretaria.getNome());
            statement.setString(2, secretaria.getDepartamento() + "");
            statement.setString(3, secretaria.getTelefone());
            statement.setString(4, secretaria.getDetalhes());
            

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }

    }

    public List<Object> findAll(){
        List<Object> list = new ArrayList<>();

        sql = " SELECT * FROM secretaria ORDER BY upper(secretaria) ";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                Secretaria secretaria = new Secretaria(
                        resultset.getInt(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5));

                list.add(secretaria);
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }

        return list;
    }

    public Object find(Object obj) {
        Secretaria secretaria = (Secretaria) obj;

        sql = " SELECT * FROM curso WHERE id = ? ";
        try {

            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setInt(1, secretaria.getId());

            ResultSet resultset = statement.executeQuery();

            Secretaria s = null;
            while (resultset.next()) {
                s = new Secretaria(
                        resultset.getInt(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5));
            }
            statement.close();
            return s;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }

    }

    public Object findByNome(String nome){
       
        sql = " Select * FROM aluno as a WHERE c.nome = ? ";

        Secretaria secretaria = null;
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                secretaria = new Secretaria(
                    resultset.getInt(1),
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5));
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }

        return secretaria;
    }

    public boolean delete(Object obj){
        Secretaria secretaria = (Secretaria) obj;
        sql = " DELETE FROM secretaria as a WHERE id = ? ";

        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, secretaria.getId());

            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                secretaria = new Secretaria(
                    resultset.getInt(1),
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5));
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return true;
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


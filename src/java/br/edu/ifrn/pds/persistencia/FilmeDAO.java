/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrn.pds.persistencia;

import br.edu.ifrn.pds.dominio.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 20201114010026
 */
public class FilmeDAO {
    public boolean inserirFilme(Filme obj){
        boolean resultado = false;
        String query = "INSERT INTO filme(id, titulo, duracao, anoLancamento, avaliacao) VALUES(?,?,?,?,?);";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setInt(1, obj.getId());
            comando.setString(2, obj.getTitulo());
            comando.setDouble(3, obj.getDuracao());
            comando.setInt(4, obj.getAnoLancamento());
            comando.setDouble(5, obj.getAvaliacao());


            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return resultado;
    }
    
     public boolean alterarFilme(Filme obj) {
        boolean resultado = false;
        String query = "UPDATE filme set id = ?, titulo = ?, duracao = ?, anoLancamento = ?, avaliacao = ? where id = ?;";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setInt(1, obj.getId());
            comando.setString(2, obj.getTitulo());
            comando.setDouble(3, obj.getDuracao());
            comando.setInt(4, obj.getAnoLancamento());
            comando.setDouble(5, obj.getAvaliacao());
            comando.setInt(6, obj.getId());

             int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return resultado;
    }

    public boolean removerFilme(int id) {
        boolean resultado = false;
        String query = "DELETE from filme where id = ?;";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setInt(1, id);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return resultado;
    }

    public Filme buscarFilme(String titulo) {

        Filme f1 = null;

        String query = "SELECT id, titulo, duracao, anoLancamento, avaliacao from filme where titulo = ?;";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setString(1, titulo);

            ResultSet resultSet = comando.executeQuery();

            if (resultSet.next()) {

                f1 = new Filme();
                f1.setId(resultSet.getInt("id"));
                f1.setTitulo(resultSet.getString("titulo"));
                f1.setDuracao(resultSet.getDouble("duracao"));
                f1.setAnoLancamento(resultSet.getInt("anoLancamento"));
                f1.setAvaliacao(resultSet.getDouble("avaliacao"));
                f1.setTitulo(resultSet.getString("titulo"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }

        return f1;
    }
    public boolean verificarExistencia(String titulo) {

        return buscarFilme(titulo) != null;
    }
    
    public List<Filme> buscarTodos() {
        
        List<Filme> filmes = new ArrayList<Filme>();

        String query = "SELECT id, titulo, duracao, anoLancamento, avaliacao from filme;";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            ResultSet resultSet = comando.executeQuery();

            while (resultSet.next()) {

                Filme f1 = new Filme();
                f1.setId(resultSet.getInt("id"));
                f1.setTitulo(resultSet.getString("titulo"));
                f1.setDuracao(resultSet.getDouble("duracao"));
                f1.setAnoLancamento(resultSet.getInt("anoLancamento"));
                f1.setAvaliacao(resultSet.getDouble("avaliacao"));
                filmes.add(f1);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }

        return filmes;
    }
    
}

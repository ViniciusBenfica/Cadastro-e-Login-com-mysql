/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Telas.TelaDeTeste;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Cadastros;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class CadastrosDAO {

    private Connection conecta;

    public CadastrosDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }

    //Cadastrar no banco
    public void cadastrar(Cadastros obj) {

        try {

            String cmdsql = "insert into cadastros(email,login,senha)values(?,?,?)";

            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getEmail());
            stmt.setString(2, obj.getLogin());
            stmt.setString(3, obj.getSenha());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    //listar os cadastros
    public List<Cadastros> listarNaTabela() {
        try {
            List<Cadastros> lista = new ArrayList<Cadastros>();
            String cmdSql = "select * from cadastros";

            PreparedStatement stmt = conecta.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cadastros v = new Cadastros();
                v.setId(rs.getInt("id"));
                v.setEmail(rs.getString("email"));
                v.setLogin(rs.getString("login"));
                v.setSenha(rs.getString("senha"));

                lista.add(v);
            }
            return lista;
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    //Alterar cadastro
    public void alterar(Cadastros obj) {

        try {

            String cmdsql = "update cadastros set email=?, login=?, senha=? where id=?";

            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getEmail());
            stmt.setString(2, obj.getLogin());
            stmt.setString(3, obj.getSenha());
            stmt.setInt(4, obj.getId());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    //Excluir cadastro
    public void excluir(Cadastros obj) {

        try {

            String cmdsql = "delete from cadastros where id = ?";

            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getId());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    //Logar
    public boolean login(String login, String senha) {

        try {

            String cmdsql = "select * from cadastros where login = ? and senha = ?";

            PreparedStatement stmt = conecta.prepareStatement(cmdsql);

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.first()) {
                return true;
            }

        } catch (SQLException e) {

        }
        return false;
    }
}

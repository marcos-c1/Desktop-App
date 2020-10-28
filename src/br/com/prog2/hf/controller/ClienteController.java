package br.com.prog2.hf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hf.model.Cliente;
import br.com.prog2.hf.persistencia.ConnectionFactory;

public class ClienteController {

	public String inserir(Cliente cli) {
		String sql = "insert into cliente(cod_cli, nome, rg, bairro, cidade, estado, cep, dataNascimento) values(?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cli.getCodCliente());
			pst.setString(2, cli.getNome());
			pst.setString(3, cli.getRg());
			pst.setString(4, cli.getBairro());
			pst.setString(5, cli.getCidade());
			pst.setString(6, cli.getEstado());
			pst.setString(7, cli.getCep());
			pst.setObject(8, cli.getDataNasc());
			int res = pst.executeUpdate();

			if (res > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public String alterar(Cliente cli) {
		String sql = "update cliente set nome=?," + "rg=?," + "bairro=?," + "cidade=?," + "estado=?," + "cep=?,"
				+ "dataNascimento=? where cod_cli=?";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cli.getNome());
			pst.setString(2, cli.getRg());
			pst.setString(3, cli.getBairro());
			pst.setString(4, cli.getCidade());
			pst.setString(5, cli.getEstado());
			pst.setString(6, cli.getCep());
			pst.setObject(7, cli.getDataNasc());
			pst.setString(8, cli.getCodCliente());
			int res = pst.executeUpdate();

			if (res > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public String excluir(Cliente cli) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from cliente where cod_cli=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, cli.getCodCliente());
			int res = pst.executeUpdate();

			if (res > 0) {
				return "Excluído com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public List<Cliente> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from cliente order by cod_cli");
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> lista = new ArrayList<>();

		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Cliente cli = new Cliente();
					cli.setCodCliente(rs.getString(1));
					cli.setNome(rs.getString(2));
					cli.setRg(rs.getString(3));
					cli.setBairro(rs.getString(4));
					cli.setCidade(rs.getString(5));
					cli.setEstado(rs.getString(6));
					cli.setCep(rs.getString(7));
					cli.setDataNasc(rs.getObject(8, LocalDate.class));
					lista.add(cli);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public Cliente pesquisarPorCliente(String cod_cli) {
		String sql = "select * from cliente where cod_cli=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cod_cli);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente cli = new Cliente();
				cli.setCodCliente(rs.getString(1));
				cli.setNome(rs.getString(2));
				cli.setRg(rs.getString(3));
				cli.setBairro(rs.getString(4));
				cli.setCidade(rs.getString(5));
				cli.setEstado(rs.getString(6));
				cli.setCep(rs.getString(7));
				cli.setDataNasc(rs.getObject(8, LocalDate.class));
				return cli;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
}

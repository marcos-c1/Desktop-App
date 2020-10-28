package br.com.prog2.hf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hf.model.Chale;
import br.com.prog2.hf.persistencia.ConnectionFactory;

public class ChaleController {
	public String inserir(Chale ch) {
		String sql = "insert into chale(cod_chale, localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao) values(?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ch.getCod_chale());
			pst.setString(2, ch.getLocalizacao());
			pst.setInt(3, ch.getCapacidade());
			pst.setDouble(4, ch.getValorAltaEstacao());
			pst.setDouble(5, ch.getValorBaixaEstacao());
			
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

	public String alterar(Chale ch) {
		String sql = "update chale set localizacao=?," + "capacidade=?," + "valorAltaEstacao=?," + "valorBaixaEstacao=? where cod_chale=?";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, ch.getLocalizacao());
			pst.setInt(2, ch.getCapacidade());
			pst.setDouble(3, ch.getValorAltaEstacao());
			pst.setDouble(4, ch.getValorBaixaEstacao());
			pst.setString(5, ch.getCod_chale());
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

	public String excluir(Chale ch) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from chale where cod_chale=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, ch.getCod_chale());
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

	public List<Chale> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from chale order by cod_chale");
		Connection con = ConnectionFactory.getConnection();
		List<Chale> lista = new ArrayList<>();

		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Chale ch = new Chale();
					ch.setCod_chale(rs.getString(1));
					ch.setLocalizacao(rs.getString(2));
					ch.setCapacidade(rs.getInt(3));
					ch.setValorAltaEstacao(rs.getDouble(4));
					ch.setValorBaixaEstacao(rs.getDouble(5));
					lista.add(ch);
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

	public Chale pesquisarPorCod(String cod_chale) {
		String sql = "select * from chale where cod_chale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cod_chale);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Chale ch = new Chale();
				ch.setCod_chale(rs.getString(1));
				ch.setLocalizacao(rs.getString(2));
				ch.setCapacidade(rs.getInt(3));
				ch.setValorAltaEstacao(rs.getDouble(4));
				ch.setValorBaixaEstacao(rs.getDouble(5));
				return ch;
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

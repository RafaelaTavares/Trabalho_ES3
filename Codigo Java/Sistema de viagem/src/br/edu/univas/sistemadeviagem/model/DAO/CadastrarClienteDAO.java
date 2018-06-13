package br.edu.univas.sistemadeviagem.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.univas.sistemadeviagem.model.Exception.CadastrarMotoristaException;
import br.edu.univas.sistemadeviagem.model.TO.CadastrarMotoristaTO;
import br.edu.univas.sistemadeviagem.model.Util.DBUtil;

public class CadastrarClienteDAO {
	
	public void insertNewCadastrarMotorista(CadastrarMotoristaTO to) throws CadastrarMotoristaException{
		
		String sentenca = "INSERT INTO CADASTRO_CLIENTE"
						+ " (COD_CLIENTE, NOME, CPF, RG, SEXO, TELEFONE, EMAIL, ENDERECO)"
						+ " VALUES (?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		try{
			
			conn = DBUtil.openConnection();
			PreparedStatement prepStat = conn.prepareStatement(sentenca);
			
			prepStat.setInt(1, to.getCodMotorista());
			prepStat.setString(2, to.getNome());
			prepStat.setString(3, to.getCpf());
			prepStat.setString(4, to.getRg());
			prepStat.setString(5, to.getSexo());
			prepStat.setString(6, to.getTelefone());
			prepStat.setString(7, to.getEmail());
			prepStat.setString(8, to.getEndereco());
			
			prepStat.execute();
		}catch (Exception e){			
			throw new CadastrarMotoristaException("Erro ao incluir cadastro de cliente \n" + e);
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public void deleteCadastrarMotorista(int codigo) throws CadastrarMotoristaException{
		
		String sql = "DELETE FROM CADASTRO_CLIENTE WHERE COD_CLIENTE = ?";
		
		Connection conn = null;		
		try {
			
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			
			prep.setInt(1, codigo);
			
			prep.execute();
		}catch (SQLException e) {
			throw new CadastrarMotoristaException("Erro excluindo a Cadastrar Cliente " + codigo);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public void updateCadastrarMotorista(CadastrarMotoristaTO to) throws CadastrarMotoristaException{
		String sentenca = "UPDATE CADASTRO_CLIENTE SET NOME = ?, CPF = ?, RG = ?, SEXO = ?"
						+ " TELEFONE = ?, EMAIL = ?, ENDERECO = ?"
						+ " WHERE COD_CLIENTE = ?";
		
		Connection conn = null;
		try{
			conn = DBUtil.openConnection();
			PreparedStatement prepStat = conn.prepareStatement(sentenca);
			
			prepStat.setString(1, to.getNome());
			prepStat.setString(2, to.getCpf());
			prepStat.setString(3, to.getRg());
			prepStat.setString(4, to.getSexo());
			prepStat.setString(5, to.getTelefone());
			prepStat.setString(6, to.getEmail());
			prepStat.setString(7, to.getEndereco());
			
			prepStat.execute();
		}catch (Exception e) {
			throw new CadastrarMotoristaException("Erro ao atualizar cadastrar cliente" + e);
		}finally {
			DBUtil.closeConnection(conn);
		}
	}

}

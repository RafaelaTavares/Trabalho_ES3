package br.edu.univas.sistemadeviagem.model.Consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.univas.sistemadeviagem.model.Exception.CadastrarClienteException;
import br.edu.univas.sistemadeviagem.model.Exception.CadastrarMotoristaException;
import br.edu.univas.sistemadeviagem.model.TO.CadastrarClienteTO;
import br.edu.univas.sistemadeviagem.model.TO.CadastrarMotoristaTO;
import br.edu.univas.sistemadeviagem.model.Util.DBUtil;

public class CadastrarClienteConsulta {
	public  CadastrarClienteTO selectCadastrarCliente(int codigo) throws CadastrarClienteException{
		
		String sentenca = "SELECT COD_CLIENTE, NOME, CPF, RG, SEXO, TELEFONE, EMAIL, ENDERECO "
						+ " FROM CADASTRO_CLIENTE"
						+ " WHERE COD_CLIENTE = ?";
			
		
		Connection conn = null;
		try{
			
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sentenca);
			prep.setInt(1, codigo);
			
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				
				int codCliente = rs.getInt(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String rg = rs.getString(4);
				String sexo = rs.getString(5);
				String telefone = rs.getString(6);
				String email = rs.getString(7);
				String endereco = rs.getString(8);
							
				CadastrarMotoristaTO to = new CadastrarClienteTO(codCliente, nome, cpf, rg, sexo, telefone, email, endereco);
				return to;
				
			}	
		}catch (Exception e) {
			throw new CadastrarMotoristaException("Erro ao consultar cadastro cliente \n" + e);
		}finally {
			DBUtil.closeConnection(conn);
		}
		return null;		
		}


}

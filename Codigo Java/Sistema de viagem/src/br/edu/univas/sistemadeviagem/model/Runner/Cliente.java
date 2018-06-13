package br.edu.univas.sistemadeviagem.model.Runner;

import br.edu.univas.sistemadeviagem.model.Consultas.CadastrarClienteConsulta;
import br.edu.univas.sistemadeviagem.model.Consultas.CadastrarMotoristaConsulta;
import br.edu.univas.sistemadeviagem.model.DAO.CadastrarClienteDAO;
import br.edu.univas.sistemadeviagem.model.Exception.CadastrarClienteException;
import br.edu.univas.sistemadeviagem.model.Exception.CadastrarMotoristaException;
import br.edu.univas.sistemadeviagem.model.TO.CadastrarClienteTO;
import br.edu.univas.sistemadeviagem.model.TO.CadastrarMotoristaTO;

public class Cliente {
	
public static void main(String[] args) {
		
//		CadastrarClienteDAO usuarioDAO = new CadastrarClienteDAO();
//		CadastrarClienteTO to = new CadastrarClienteTO(12, "Rafaela", 1234, 12345, "Feminino", 9999, "rafa-tavares@hotmail.com", "Rua");
//		try {
//			usuarioDAO.insertNewCadastrarCliente(to);
//		} catch (CadastrarClienteException e) {
//			System.out.println("Erro ao salvar cadastro de usuario\n");
//			e.printStackTrace();
//		}
//		System.out.println("Sucesso ao salvar cadastro de usuario\n");
		
		CadastrarClienteConsulta motoristaConsulta = new CadastrarClienteConsulta();
		CadastrarClienteTO resultConsulta = new CadastrarClienteTO();
		try {
			resultConsulta = clienteConsulta.selectCadastrarCliente(12);
		} catch (CadastrarMotoristaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resultConsulta.getNome());

	}

}

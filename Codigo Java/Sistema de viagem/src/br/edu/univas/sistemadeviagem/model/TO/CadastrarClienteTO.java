package br.edu.univas.sistemadeviagem.model.TO;

public class CadastrarClienteTO {
	
	int codCliente;
	String nome;
	String cpf;
	String rg;
	String sexo;
	String telefone;
	String email;
	String endereco;

	public CadastrarClienteTO() {
		
	}
	
	public CadastrarClienteTO(int codCliente, String nome, String cpf, String rg, String sexo, String telefone, String email, String endereco){
		this.codCliente = codCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getSexo() {
		return sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}
	
	
}

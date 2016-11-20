package model;

import java.sql.Date;

public class Professor {
	private String cpf, curriculo, rg, email,cep, email_prof, status, logradouro, numero, complemento, telefone, nome, curso;
	private Date dt_nascimento,dt_contratacao;
	private int idCurso;
	
	public Professor(String cpf, String curriculo, String rg, String email, String email_prof, String status,
			String cep, String logradouro, String numero, String complemento, String telefone, String nome,
			Date dt_nascimento, Date dt_contratacao, String curso, int idCurso) {
		super();
		this.cpf = cpf;
		this.curriculo = curriculo;
		this.rg = rg;
		this.email = email;
		this.email_prof = email_prof;
		this.status = status;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.nome = nome;
		this.dt_nascimento = dt_nascimento;
		this.dt_contratacao = dt_contratacao;
		this.idCurso = idCurso;
		this.curso = curso;
	}

	public String getEndereco(){
		return cep +" "+logradouro+" "+numero+" "+complemento;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCurriculo() {
		return curriculo;
	}
	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	@Override
	public String toString(){
		return this.nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail_prof() {
		return email_prof;
	}

	public void setEmail_prof(String email_prof) {
		this.email_prof = email_prof;
	}

	public Date getDt_contratacao() {
		return dt_contratacao;
	}

	public void setDt_contratacao(Date dt_contratacao) {
		this.dt_contratacao = dt_contratacao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}

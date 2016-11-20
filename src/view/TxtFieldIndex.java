package view;

public enum TxtFieldIndex {
	NOME_DISC("Nome: "),
	SIGLA("Sigla: "),
	EMENTA("Ementa: "),
	ID_DISC("ID: "),
	CRED_AULA("Créditos Aula: "),
	CRED_TRAB("Créditos Trabalho: "),
	PER_IDEAL("Período Ideal: "),
	
	CPF("CPF: "),
	CURR("Link currículo: "),
	RG("RG: "),
	EMAIL("Email: "),
	CEP("CEP: "),
	LOGRADOURO("Logradouro: "),
	NUM("Número casa: "),
	COMPLEMENTO("Complemento: "),
	STATUS("Status: "),
	EMAIL_PROF("Email profisiional: "),
	NOME_PROF("Nome: "),
	TEL("Telefone: "),
	DT_CONTRATACAO("Data de contratação: "),
	DT_NASC("Data de nascimento: "),
	CURSO("Curso: ");
	
	private String lbl;
	
	private TxtFieldIndex(String lbl){
		this.lbl = lbl;
	}
	
	public String getLbl(){
		return lbl;
	}
}

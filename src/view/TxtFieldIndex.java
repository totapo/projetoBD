package view;

public enum TxtFieldIndex {
	NOME_DISC("Nome: "),
	SIGLA("Sigla: "),
	EMENTA("Ementa: "),
	ID_DISC("ID: "),
	CRED_AULA("Cr�ditos Aula: "),
	CRED_TRAB("Cr�ditos Trabalho: "),
	PER_IDEAL("Per�odo Ideal: "),
	
	CPF("CPF: "),
	CURR("Link curr�culo: "),
	RG("RG: "),
	EMAIL("Email: "),
	CEP("CEP: "),
	LOGRADOURO("Logradouro: "),
	NUM("N�mero casa: "),
	COMPLEMENTO("Complemento: "),
	STATUS("Status: "),
	EMAIL_PROF("Email profisiional: "),
	NOME_PROF("Nome: "),
	TEL("Telefone: "),
	DT_CONTRATACAO("Data de contrata��o: "),
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

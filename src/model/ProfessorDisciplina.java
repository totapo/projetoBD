package model;

public class ProfessorDisciplina {
	private int idDis;
	private String cpf, nomeProf, siglaDisc;
	public int getIdDis() {
		return idDis;
	}
	public void setIdDis(int idDis) {
		this.idDis = idDis;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeProf() {
		return nomeProf;
	}
	public void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}
	public String getSiglaDisc() {
		return siglaDisc;
	}
	public void setSiglaDisc(String siglaDisc) {
		this.siglaDisc = siglaDisc;
	}
	
	public ProfessorDisciplina(int idDis, String cpf, String nomeProf, String siglaDisc) {
		super();
		this.idDis = idDis;
		this.cpf = cpf;
		this.nomeProf = nomeProf;
		this.siglaDisc = siglaDisc;
	}
}

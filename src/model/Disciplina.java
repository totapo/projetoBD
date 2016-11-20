package model;

public class Disciplina {
	private String sigla, ementa, nome;
	private long id;
	private int creditoTrab, creditoAula, periodoIdeal;
	
	public Disciplina(String sigla, String ementa, String nome, long id, int creditoTrab, int creditoAula,
			int periodoIdeal) {
		super();
		this.sigla = sigla;
		this.ementa = ementa;
		this.nome = nome;
		this.id = id;
		this.creditoTrab = creditoTrab;
		this.creditoAula = creditoAula;
		this.periodoIdeal = periodoIdeal;
	}

	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCreditoTrab() {
		return creditoTrab;
	}
	public void setCreditoTrab(int creditoTrab) {
		this.creditoTrab = creditoTrab;
	}
	public int getCreditoAula() {
		return creditoAula;
	}
	public void setCreditoAula(int creditoAula) {
		this.creditoAula = creditoAula;
	}
	public int getPeriodoIdeal() {
		return periodoIdeal;
	}
	public void setPeriodoIdeal(int periodoIdeal) {
		this.periodoIdeal = periodoIdeal;
	}
	
	@Override
	public String toString(){
		return this.sigla;
	}
}

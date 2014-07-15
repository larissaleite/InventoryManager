package br.com.projeto.modelo;

public enum Mes {
	
	JANEIRO("Janeiro"),
	FEVEREIRO("Fevereiro"),
	MARCO("Marco"),
	ABRIL("Abril"),
	MAIO("Maio"),
	JUNHO("Junho"),
	JULHO("Julho"),
	AGOSTO("Agosto"),
	SETEMBRO("Setembro"),
	OUTUBRO("Outubro"),
	NOVEMBRO("Novembro"),
	DEZEMBRO("Dezembro");
	
	private String label;

	Mes(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}

package br.com.projeto.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

import br.com.projeto.modelo.Estoque;
import br.com.projeto.service.IServiceEstoque;

//@ManagedBean(name="estoqueMBean")
@Controller
@Scope("request")
public class EstoqueMBean {
	
	@Autowired
	private IServiceEstoque serviceEstoque;
	
	private List<Estoque> estoques;

	public EstoqueMBean() {
		//se usar dessa forma, dentro do construtor, gera nullpointerexception pq os componentes Autowired só são criados após o construtor
		//this.estoques = serviceEstoque.recuperarEstoque();
	}
	
	//method which is to be executed when the class has been constructed and all dependency injections are been finished
	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		this.estoques = serviceEstoque.recuperarEstoque();
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

}

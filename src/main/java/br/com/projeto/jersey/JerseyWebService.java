package br.com.projeto.jersey;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.projeto.modelo.Estoque;
import br.com.projeto.modelo.Mes;
import br.com.projeto.service.ServiceEstoque;
import br.com.projeto.spring.util.SpringUtils;
 
@Path("/grafico")
public class JerseyWebService {
	
	@GET
	@Path("/vendasMensal") //ajeitar pra ser um metodo generico que recebe o tipo do grafico e redireciona pra o metodo q retorna os dados especificos pra o determinado grafico
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Integer> getData() {
		ServiceEstoque serviceEstoque = (ServiceEstoque) SpringUtils.getBean("serviceEstoque");
		ArrayList<Integer> quantVendas = (ArrayList<Integer>)serviceEstoque.recuperarQuantVendas();
		
		return quantVendas;
	}
	
	@GET
	@Path("/estoqueMes")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Estoque> getEstoqueMes() {
		ServiceEstoque serviceEstoque = (ServiceEstoque) SpringUtils.getBean("serviceEstoque");
		ArrayList<Estoque> estoqueMes = (ArrayList<Estoque>) serviceEstoque.recuperarEstoqueNoMes(Mes.JULHO);
		
		return estoqueMes;
	}
	
	@GET
	@Path("/lucroAnual")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Integer> getLucroAnual() {
		ServiceEstoque serviceEstoque = (ServiceEstoque) SpringUtils.getBean("serviceEstoque");
		ArrayList<Integer> lucro = (ArrayList<Integer>)serviceEstoque.lucroAnual();
		
		return lucro;
	}

}

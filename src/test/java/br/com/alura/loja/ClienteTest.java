package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import junit.framework.Assert;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	private HttpServer server;

	@Before
	public void startaServidor() {
		server = Servidor.inicializaServidor();
	}

	@After
	public void mataServidor() {
		server.stop();
	}

	// @Test
	// public void testaQueBuscaUmCarrinhoTrazUmCarrinho() {
	//
	// Client client = ClientBuilder.newClient();
	// WebTarget target = client.target("http://localhost:8080");
	// String conteudo = target.path("/projetos/1").request()
	// .get(String.class);
	// System.out.println(conteudo);
	// Projeto carrinho = (Projeto) new XStream().fromXML(conteudo);
	// Assert.assertEquals("Minha loja", carrinho.getNome());
	//
	// }

	@Test
	public void testaQueAConexaoComOServidorFunciona() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io");
		String conteudo = target.path("/v2/52aaf5deee7ba8c70329fb7d").request()
				.get(String.class);
		Assert.assertTrue(conteudo.contains("<rua>Rua Vergueiro 3185"));
	}
}

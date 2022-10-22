package com.fabrica.software.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fabrica.software.entities.Categoria;
import com.fabrica.software.entities.ItensPedido;
import com.fabrica.software.entities.Pagamento;
import com.fabrica.software.entities.Pedido;
import com.fabrica.software.entities.Produto;
import com.fabrica.software.entities.Usuario;
import com.fabrica.software.entities.enums.PedidoStatus;
import com.fabrica.software.repositories.CategoriaRepository;
import com.fabrica.software.repositories.ItensPedidoRepository;
import com.fabrica.software.repositories.PedidoRepository;
import com.fabrica.software.repositories.ProdutoRepository;
import com.fabrica.software.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItensPedidoRepository itensPedidoRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "123456");
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),PedidoStatus.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),PedidoStatus.CANCELADO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),PedidoStatus.TRANSITANDO, u1);
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
		
		ItensPedido ip1 = new ItensPedido(o1, p1, 2, p1.getPreco());
		ItensPedido ip2 = new ItensPedido(o1, p3, 1, p3.getPreco());
		ItensPedido ip3 = new ItensPedido(o2, p3, 2, p3.getPreco());
		ItensPedido ip4 = new ItensPedido(o3, p5, 2, p5.getPreco());
	
		itensPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3,ip4));
		
		Pagamento pagamento1= new Pagamento(null, Instant.parse("2019-07-22T17:21:22Z"), o1);
		
		o1.setPagamento(pagamento1);
		
		pedidoRepository.save(o1);
	
	}	
	
	
}

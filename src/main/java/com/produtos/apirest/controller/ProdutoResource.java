package com.produtos.apirest.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.produtos.api.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="Api REST Produtos")
@CrossOrigin(origins = "*") //liberar os dominios para acesso api
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	//listar todos Produtos do banco
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produto> listaProduto(){
			
		return produtoRepository.findAll();
		
	}
	
	//listar  Produto do banco por ID
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um unico produto")
	public Produto listaProduto(@PathVariable(value = "id") long id){
			
		return produtoRepository.findById(id);
		
	}
	
	// Salvar Produto do banco passando Produto
	
	@PostMapping("/produto")
	@ApiOperation(value = "Salva o produtos")
	public Produto salvarProdutos(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
	}
	
	//MTD para deletar Produto passando um produto
	
	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta um produtos")
	public void deletarProdutos(@RequestBody Produto produto) {
		
		 produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value = "Atualiza um produtos")
	public Produto EditarProdutos(@RequestBody Produto produto) {
		System.out.println("Editado com sucesso");
		return produtoRepository.save(produto);
	}
	
}

package com.atv.ex07.Controller;

import com.atv.ex07.Model.Fornecedor;
import com.atv.ex07.Service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor request = service.criarFornecedor(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        List<Fornecedor> request = service.listaFornecedores();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedorPorId(@PathVariable Long id) {
        Optional<Fornecedor> request = service.exibeFornecedor(id);
        return ResponseEntity.ok().body(request.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fornecedor> excluirFornecedor(@PathVariable Long id) {
        service.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}

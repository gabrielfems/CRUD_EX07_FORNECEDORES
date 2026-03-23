package com.atv.ex07.Service;

import com.atv.ex07.Model.Fornecedor;
import com.atv.ex07.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> listaFornecedores() {
        return repository.findAll();
    }

    public Optional<Fornecedor> exibeFornecedor(Long id) {
        return repository.findById(id);
    }

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public void deletarFornecedor(Long id) {
        repository.deleteById(id);
    }

}

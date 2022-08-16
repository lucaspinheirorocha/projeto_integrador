package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.exception.NotFoundException;
import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository repo;

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> costumer = repo.findById(id);
        if(costumer.isEmpty()){
            throw new NotFoundException("Customer not found");
        }
        return costumer.get();
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
        return null;
    }
}

package org.example.thijavawebservice.Service;

import org.example.thijavawebservice.Entity.Employee;
import org.example.thijavawebservice.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo) { this.repo = repo; }

    public List<Employee> getAll() { return repo.findAll(); }
    public Employee add(Employee e) { return repo.save(e); }
    public Employee update(Employee e) { return repo.save(e); }
    public void delete(Long id) { repo.deleteById(id); }
    public Employee findById(Long id) { return repo.findById(id).orElse(null); }
}

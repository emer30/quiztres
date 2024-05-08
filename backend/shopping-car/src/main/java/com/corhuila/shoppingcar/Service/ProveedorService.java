package com.corhuila.shoppingcar.Service;


import com.corhuila.shoppingcar.Document.Proveedor;
import com.corhuila.shoppingcar.IRepository.IProveedorRepository;
import com.corhuila.shoppingcar.IService.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorRepository repository;

    @Override
    public List<Proveedor> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public void update(Proveedor proveedor, String id) {
        //Obtener el objeto cliente y el id
        //Verificar con el id, si exiten los datos
        Optional<Proveedor> ps = repository.findById(id);

        //Cargar nuevo objeto
        if (!ps.isEmpty()){
            Proveedor proveedorUpdate = ps.get();
            proveedorUpdate.setCodigo(proveedor.getCodigo());
            proveedorUpdate.setNombre(proveedor.getNombre());
            proveedorUpdate.setDireccion(proveedor.getDireccion());


            //Actualizar el objeto cliente
            repository.save(proveedorUpdate);
        }else{
            System.out.println("No existe el cliente");
        }
    }

    @Override
    public void deleteLogical(Proveedor cliente, String id) {
        //Obtener el objeto cliente y el id
        //Verificar con el id, si exiten los datos
        Optional<Proveedor> ps = repository.findById(id);

        //Cargar nuevo objeto
        if (!ps.isEmpty()){
            Proveedor clienteUpdate = ps.get();
            //Reportar fecha de eliminación
            //clienteUpdate.setNombre(cliente.getNombre());
            //Actualizar el objeto cliente
            repository.save(clienteUpdate);
        }else{
            System.out.println("No existe el cliente");
        }
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

}

package com.api.crud.services;

import com.api.crud.models.Producto;
import com.api.crud.models.ProductoDto;
import com.api.crud.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    FilesServices filesServices;

    public Optional<Producto> findByNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }
    public Optional<Producto> finById(Integer id) {
        return productoRepository.findById(id);
    }
    public Optional<Producto> findByNombreAndProductor(String nombre, String productor) {
        return productoRepository.findByNombreAndProductor(nombre, productor);
    }


    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public void save(Producto producto, MultipartFile file) throws Exception {

        String nombreImagen = "generica.png";

        if (file != null) {
            nombreImagen = filesServices.uploadFile(file);
        }

        producto.setImagen(nombreImagen);
        productoRepository.save(producto);

    }

    public void update(Producto producto, MultipartFile file) throws Exception {

        if (file != null) {
            String nombreImagen = filesServices.uploadFile(file);
            producto.setImagen(nombreImagen);
        }
        productoRepository.findById(producto.getId());

        productoRepository.save(producto);

    }

    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

    private ProductoDto mapProductoDto(Producto producto) throws MalformedURLException {

        ProductoDto dto = new ProductoDto();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setTipo(producto.getTipo());
        dto.setProductor(producto.getProductor());
        dto.setPrecio(producto.getPrecio());
        dto.setImagen(filesServices.obtenerImagen(producto.getImagen()));

        return dto;
    }

}

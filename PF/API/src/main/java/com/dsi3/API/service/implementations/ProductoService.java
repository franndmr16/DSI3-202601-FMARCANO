package com.dsi3.API.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi3.API.mapper.ProductoMapper;
import com.dsi3.API.model.dto.ProductoDTO;
import com.dsi3.API.model.entity.Producto;
import com.dsi3.API.repository.ProductoRepository;
import com.dsi3.API.service.interfaces.IProductoService;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductoDTO> listarTodos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDTO> filtrarPorDisponibilidad(Boolean disponible) {
        return productoRepository.findByDisponible(disponible).stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDTO> filtrarPorCategoriaYDisponibilidad(String categoria, Boolean disponible) {
        return productoRepository.findByCategoriaAndDisponible(categoria, disponible).stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO buscarPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return productoMapper.toDTO(producto);
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        Producto producto = productoMapper.toEntity(productoDTO);
        return productoMapper.toDTO(productoRepository.save(producto));
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        Producto productoExistente = productoRepository.findById(id).orElse(null);
        if (productoExistente != null) {
            productoExistente.setNombre(productoDTO.getNombre());
            productoExistente.setDescripcion(productoDTO.getDescripcion());
            productoExistente.setPrecio(productoDTO.getPrecio());
            productoExistente.setCategoria(productoDTO.getCategoria());
            productoExistente.setDisponible(productoDTO.isDisponible());
            return productoMapper.toDTO(productoRepository.save(productoExistente));
        }
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
package com.dsi3.API.service.implementations;


import com.dsi3.API.model.dto.PedidoRequestDTO;
import com.dsi3.API.model.dto.PedidoResponseDTO;
import com.dsi3.API.model.entity.*;
import com.dsi3.API.repository.*;
import com.dsi3.API.mapper.PedidoMapper;
import com.dsi3.API.service.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public List<PedidoResponseDTO> listarTodos() {
        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoResponseDTO buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        return pedidoMapper.toResponseDTO(pedido);
    }

    @Override
    @Transactional
    public PedidoResponseDTO crearPedido(PedidoRequestDTO dto) {
        Mesa mesaDb = mesaRepository.findById(dto.getIdMesa())
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada"));

        Cliente clienteDb = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Usuario usuarioDb = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        mesaDb.setEstado(Mesa.EstadoMesa.OCUPADA);
        mesaRepository.save(mesaDb);
        Pedido pedido = new Pedido();
        pedido.setMesa(mesaDb);
        pedido.setCliente(clienteDb);
        pedido.setUsuario(usuarioDb);
        pedido.setEstado(Pedido.EstadoPedido.CREADA);
        Pedido pedidoGuardadoBase = pedidoRepository.save(pedido);
        List<DetallePedido> detallesEntidad = new ArrayList<>();
        double totalPedido = 0.0;

        for (PedidoRequestDTO.DetallePedidoRequestDTO detDto : dto.getDetalles()) {
            Producto productoDb = productoRepository.findById(detDto.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + detDto.getIdProducto()));

            DetallePedido detalle = new DetallePedido();
            detalle.setPedido(pedidoGuardadoBase);
            detalle.setProducto(productoDb);
            detalle.setCantidad(detDto.getCantidad());
            detalle.setPrecioUnitario(productoDb.getPrecio());
            
            double subtotal = productoDb.getPrecio() * detDto.getCantidad();
            detalle.setSubtotal(subtotal);
            
            totalPedido += subtotal;

            detallesEntidad.add(detallePedidoRepository.save(detalle));
        }

        pedidoGuardadoBase.setDetalles(detallesEntidad);

        return pedidoMapper.toResponseDTO(pedidoGuardadoBase);
    }

    @Override
    @Transactional
    public PedidoResponseDTO cambiarEstado(Long id, String nuevoEstado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        Pedido.EstadoPedido estado = Pedido.EstadoPedido.valueOf(nuevoEstado.toUpperCase());
        pedido.setEstado(estado);
        if (estado == Pedido.EstadoPedido.ENTREGADA) {
            Mesa mesa = pedido.getMesa();
            mesa.setEstado(Mesa.EstadoMesa.LIBRE);
            mesaRepository.save(mesa);
        }

        return pedidoMapper.toResponseDTO(pedidoRepository.save(pedido));
    }

    @Override
    @Transactional
    public void eliminarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            Mesa mesa = pedido.getMesa();
            if (mesa != null) {
                mesa.setEstado(Mesa.EstadoMesa.LIBRE); 
                mesaRepository.save(mesa);
            }
            pedidoRepository.deleteById(id);
        }
    }
}
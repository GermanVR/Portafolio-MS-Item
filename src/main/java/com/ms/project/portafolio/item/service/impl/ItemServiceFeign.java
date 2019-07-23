package com.ms.project.portafolio.item.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.project.portafolio.commons.bean.ProductoBean;
import com.ms.project.portafolio.item.bean.ItemBean;
import com.ms.project.portafolio.item.clients.ProductoCliente;
import com.ms.project.portafolio.item.service.ItemService;

/**
 * @author German Vazquez Renteria
 * Date:  22 jul. 2019
 * Package Name: com.ms.project.portafolio.item.service.impl
 * Project Name: ms-item
 */
@Service("serviceFeign")
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoCliente clienteFeign;

	@Override
	public List<ItemBean> findAll() {
		return clienteFeign.listar().stream().map(p -> new ItemBean(p, 1)).collect(Collectors.toList());
	}

	@Override
	public ItemBean findById(Long id, Integer cantidad) {
		return new ItemBean(clienteFeign.detalle(id), cantidad);
	}

	@Override
	public ProductoBean save(ProductoBean producto) {
		return clienteFeign.crear(producto);
	}

	@Override
	public ProductoBean update(ProductoBean producto, Long id) {
		return clienteFeign.update(producto, id);
	}

	@Override
	public void delete(Long id) {
		clienteFeign.eliminar(id);
	}

}

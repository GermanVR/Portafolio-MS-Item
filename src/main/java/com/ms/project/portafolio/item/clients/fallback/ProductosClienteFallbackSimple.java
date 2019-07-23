package com.ms.project.portafolio.item.clients.fallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ms.project.portafolio.commons.bean.ProductoBean;
import com.ms.project.portafolio.item.clients.ProductoCliente;

import lombok.AllArgsConstructor;

/**
 * @author German Vazquez Renteria
 * Date:  23 jul. 2019
 * Package Name: com.ms.project.portafolio.item.clients.fallback
 * Project Name: ms-item
 */
@AllArgsConstructor
@Component
public class ProductosClienteFallbackSimple implements ProductoCliente {

	@Override
	public List<ProductoBean> listar() {
		return new ArrayList<>(
				Arrays.asList(new ProductoBean(-1L, "Error con FallBack Simple", -100.0, new Date(), -100)));
	}

	@Override
	public ProductoBean detalle(Long id) {
		return null;
	}

	@Override
	public ProductoBean crear(ProductoBean producto) {
		return null;
	}

	@Override
	public ProductoBean update(ProductoBean producto, Long id) {
		return null;
	}

	@Override
	public void eliminar(Long id) {
		throw new UnsupportedOperationException();
	}

}

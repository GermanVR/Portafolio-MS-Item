package com.ms.project.portafolio.item.clients.fallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ms.project.portafolio.commons.bean.ProductoBean;
import com.ms.project.portafolio.item.clients.ProductoCliente;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author German Vazquez Renteria
 * Date:  23 jul. 2019
 * Package Name: com.ms.project.portafolio.item.clients.fallback
 * Project Name: ms-item
 */
@AllArgsConstructor
@Slf4j
public class ProductosClienteFallback implements ProductoCliente {

	private Throwable cause;

	@Override
	public List<ProductoBean> listar() {
		log.info("Error: {}", cause.getMessage(), cause);
		return new ArrayList<>(
				Arrays.asList(new ProductoBean(-2L, "Error con FallBack Factory", -200.0, new Date(), -200)));
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

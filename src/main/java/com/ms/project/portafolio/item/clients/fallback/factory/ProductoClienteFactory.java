package com.ms.project.portafolio.item.clients.fallback.factory;

import org.springframework.stereotype.Component;

import com.ms.project.portafolio.item.clients.fallback.ProductosClienteFallback;

import feign.hystrix.FallbackFactory;

/**
 * @author German Vazquez Renteria
 * Date:  23 jul. 2019
 * Package Name: com.ms.project.portafolio.item.clients.fallback.factory
 * Project Name: ms-item
 */
@Component
public class ProductoClienteFactory implements FallbackFactory<ProductosClienteFallback> {

	@Override
	public ProductosClienteFallback create(Throwable cause) {
		return new ProductosClienteFallback(cause);
	}

}

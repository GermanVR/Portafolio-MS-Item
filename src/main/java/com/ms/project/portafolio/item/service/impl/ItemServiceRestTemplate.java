package com.ms.project.portafolio.item.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.project.portafolio.commons.bean.ProductoBean;
import com.ms.project.portafolio.item.bean.ItemBean;
import com.ms.project.portafolio.item.service.ItemService;

/**
 * @author German Vazquez Renteria
 * Date:  22 jul. 2019
 * Package Name: com.ms.project.portafolio.item.service.impl
 * Project Name: ms-item
 */
@Service("serviceRestTemplate")
public class ItemServiceRestTemplate implements ItemService {

	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<ItemBean> findAll() {
		List<ProductoBean> productos = Arrays
				.asList(clienteRest.getForObject("http://ms-productos/listar", ProductoBean[].class));
		return productos.stream().map(p -> new ItemBean(p, 1)).collect(Collectors.toList());
	}

	@Override
	public ItemBean findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		ProductoBean producto = clienteRest.getForObject("http://ms-productos/ver/{id}", ProductoBean.class,
				pathVariables);
		return new ItemBean(producto, cantidad);
	}

	@Override
	public ProductoBean save(ProductoBean producto) {
		HttpEntity<ProductoBean> body = new HttpEntity<>(producto);

		ResponseEntity<ProductoBean> response = clienteRest.exchange("http://ms-productos/crear", HttpMethod.POST,
				body, ProductoBean.class);
		return response.getBody();
	}

	@Override
	public ProductoBean update(ProductoBean producto, Long id) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());

		HttpEntity<ProductoBean> body = new HttpEntity<>(producto);
		ResponseEntity<ProductoBean> response = clienteRest.exchange("http://ms-productos/editar/{id}",
				HttpMethod.PUT, body, ProductoBean.class, pathVariables);

		return response.getBody();
	}

	@Override
	public void delete(Long id) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		clienteRest.delete("http://ms-productos/eliminar/{id}", pathVariables);

	}

}

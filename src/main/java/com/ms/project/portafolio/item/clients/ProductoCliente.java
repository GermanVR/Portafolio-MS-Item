package com.ms.project.portafolio.item.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ms.project.portafolio.commons.bean.ProductoBean;
import com.ms.project.portafolio.item.clients.fallback.factory.ProductoClienteFactory;

/**
 * @author German Vazquez Renteria 
 * Date: 22 jul. 2019 
 * Package Name: com.ms.project.portafolio.item.clients 
 * Project Name: ms-item
 */
//@FeignClient(name = "ms-productos", fallback = ProductosClienteFallbackSimple.class)
@FeignClient(name = "ms-productos", fallbackFactory = ProductoClienteFactory.class)
public interface ProductoCliente {

	@GetMapping("/listar")
	public List<ProductoBean> listar();

	@GetMapping("/ver/{id}")
	public ProductoBean detalle(@PathVariable Long id);

	@PostMapping("/crear")
	public ProductoBean crear(@RequestBody ProductoBean producto);

	@PutMapping("/editar/{id}")
	public ProductoBean update(@RequestBody ProductoBean producto, @PathVariable Long id);

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id);
}

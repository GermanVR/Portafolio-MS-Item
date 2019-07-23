package com.ms.project.portafolio.item.bean;

import com.ms.project.portafolio.commons.bean.ProductoBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author German Vazquez Renteria
 * Date:  22 jul. 2019
 * Package Name: com.ms.project.portafolio.item.bean
 * Project Name: ms-item
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemBean {

	private ProductoBean producto;
	private Integer cantidad;

	public Double getTotal() {
		return producto.getPrecio() * cantidad.doubleValue();
	}

}

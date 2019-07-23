package com.ms.project.portafolio.item.service;

import java.util.List;

import com.ms.project.portafolio.commons.bean.ProductoBean;
import com.ms.project.portafolio.item.bean.ItemBean;

/**
 * @author German Vazquez Renteria
 * Date:  22 jul. 2019
 * Package Name: com.ms.project.portafolio.item.service
 * Project Name: ms-item
 */
public interface ItemService {

	public List<ItemBean> findAll();

	public ItemBean findById(Long id, Integer cantidad);

	public ProductoBean save(ProductoBean producto);

	public ProductoBean update(ProductoBean producto, Long id);

	public void delete(Long id);
}

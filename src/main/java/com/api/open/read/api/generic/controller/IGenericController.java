/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.open.read.api.generic.controller;

import com.api.open.read.api.generic.entity.BaseEntity;
import com.api.open.read.api.generic.entity.BaseEntity;
import com.api.open.read.api.generic.model.CrudApiResponse;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author NMSLAP570
 */
public interface IGenericController<T extends BaseEntity> {

    ResponseEntity<CrudApiResponse<T>> findAll();

    /**
     *
     * @param id
     * @return
     */
    ResponseEntity<CrudApiResponse<T>> findById(@PathVariable Long id);

    ResponseEntity<CrudApiResponse<T>> findAllByPageable(
            Boolean isPaged,
            @SortDefault(sort = "priRole")
            @PageableDefault(size = 20) final Pageable pageable);

    ResponseEntity<CrudApiResponse<T>> findByFilter(T t,
            Boolean isPaged,
            @SortDefault(sort = "id") @PageableDefault(size = 10) Pageable pageable,
            Boolean matchingAny);

    ResponseEntity<CrudApiResponse<T>> updateEntity(@RequestBody T t);

    ResponseEntity<CrudApiResponse<T>> createEntity(@RequestBody T t);

    public void exportData(
            List<T> list,
            HttpServletResponse response);

}

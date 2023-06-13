/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.open.read.api.service;

import com.api.open.read.api.entity.BaseEntity;
import com.api.open.read.api.entity.SimplePage;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.api.open.read.api.repository.OpenReadApiRepository;

/**
 *
 * @author NMSLAP570
 * @param <T>
 */
@Service
@Slf4j
public class OpenReadService<T extends BaseEntity> implements IOpenReadService<T> {

//    @Autowired
    protected OpenReadApiRepository<T> openReadRepository;

    @Override
    public List<T> findAll() {
        return openReadRepository.findAll();
    }

    @Override
    public SimplePage<T> findByValue(T t, Pageable pageable, Boolean matchingAny) {
        log.info(" In Method :: {} {} ", t);
        ExampleMatcher matcher = null;
        if (matchingAny) {
            matcher = ExampleMatcher.matchingAny();
        } else {
            matcher = ExampleMatcher.matchingAll();
        }

        final Page<T> page = openReadRepository.findAll(Example.of(t, matcher), pageable);
        log.info(" Successfully fectched purchase order list of size :: {} ", page.getNumberOfElements());
        return new SimplePage<>(page.getContent(), page.getTotalElements(), pageable);

    }

    @Override
    public T findById(Long id) {
        try {
            Optional<T> optional = openReadRepository.findById(id);
            return optional.isPresent() ? optional.get() : null;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public SimplePage<T> findAll(final Pageable pageable) {
        final Page<T> page = openReadRepository.findAll(pageable);
        return new SimplePage<>(page.getContent(), page.getTotalElements(), pageable);
    }
   

}

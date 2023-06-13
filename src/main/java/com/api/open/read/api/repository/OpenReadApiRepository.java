/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.open.read.api.repository;

/**
 *
 * @author NMSLAP570
 */
import com.api.open.read.api.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface OpenReadApiRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.open.read.api.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import lombok.Getter;

/**
 *
 * @author NMSLAP570
 */
@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private T id;

//    @Transient
//    protected String tableName;
//    @Transient
////    protected String tableviewName;
//    @Transient
//    protected String tableApiName;
//    @Transient
//    protected Boolean serverPaginationEnabled;

    public BaseEntity() {
    }

//    protected abstract String getTableName();

//    protected abstract String getTableviewName();

//    protected abstract String getTableApiName();

//    protected abstract Boolean getServerPaginationEnabled();

//    @Override
//    public String toString() {
//        return "BaseEntity{" + "tableName=" + tableName + ", tableviewName=" + tableviewName + ", tableApiName=" + tableApiName + ", serverPaginationEnabled=" + serverPaginationEnabled + '}';
//    }

}

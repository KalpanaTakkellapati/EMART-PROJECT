package com.project.emart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.emart.entity.ItemEntity;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity,Integer> {

}

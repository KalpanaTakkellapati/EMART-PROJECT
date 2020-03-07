package com.project.emart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.emart.entity.CategoryEntity;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity,Integer> {

}

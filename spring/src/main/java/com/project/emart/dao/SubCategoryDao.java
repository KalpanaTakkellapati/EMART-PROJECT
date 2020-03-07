package com.project.emart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.emart.entity.SubCategoryEntity;

@Repository
public interface SubCategoryDao extends JpaRepository<SubCategoryEntity,Integer> {

}

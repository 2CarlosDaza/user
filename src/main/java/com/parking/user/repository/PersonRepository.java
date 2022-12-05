package com.parking.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parking.user.model.entity.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity,Integer>{

}

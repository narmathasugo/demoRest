package com.sigma.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigma.demo.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

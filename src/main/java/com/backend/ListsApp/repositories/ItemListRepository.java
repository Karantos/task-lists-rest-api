package com.backend.ListsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ListsApp.entities.ItemList;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {
	
}

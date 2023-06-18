package com.backend.ListsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ListsApp.entities.ListOfItems;

public interface ListOfItemsRepository extends JpaRepository<ListOfItems, Long> {
	// ListOfItems getListOfItemsById(Long listId);
}

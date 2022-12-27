package com.iiht.training.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.auction.entity.BidsEntity;

@Repository
public interface BidsRepository extends JpaRepository<BidsEntity, Long> {

	
}

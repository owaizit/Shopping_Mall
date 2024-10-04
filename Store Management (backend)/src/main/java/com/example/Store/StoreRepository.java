package com.example.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Store.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

}

package com.example.Store;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Store.Store;
import com.example.Store.StoreService;

@RestController
@RequestMapping("/storeservice")
public class StoreController {
	@Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable int id) {
        Store store = storeService.getStoreById(id);
        return store != null ? ResponseEntity.ok(store) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Store addStore(@RequestBody Store store) {
        return storeService.addStore(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable int id, @RequestBody Store store) {
        Store updatedStore = storeService.updateStore(id, store);
        return updatedStore != null ? ResponseEntity.ok(updatedStore) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }
}

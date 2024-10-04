package com.example.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Store.Store;
import com.example.Store.StoreRepository;
import java.util.List;
import com.example.Store.Store;
import java.util.List;
import java.util.Optional;
@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

  
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

  
    public Store getStoreById(int id) {
        Optional<Store> store = storeRepository.findById(id);
        return store.orElse(null);
    }


    public Store addStore(Store store) {
        return storeRepository.save(store);
    }
    public Store updateStore(int id, Store store) {
        if (storeRepository.existsById(id)) {
            store.setStoreId(id);
            return storeRepository.save(store);
        }
        return null;
    }

  
    public void deleteStore(int id) {
        storeRepository.deleteById(id);
    }
}

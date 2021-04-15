package com.example.moy_sklad.services;

import com.example.moy_sklad.models.entity.Product;
import com.example.moy_sklad.models.entity.Storage;
import com.example.moy_sklad.repositories.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {
    public List<Storage> getAllStorages() {
        return storageRepository.findAll();
    }

    @Autowired
    private StorageRepository storageRepository;

    public void addStorage(Storage storage) {
        storageRepository.save(storage);
    }

    public void deleteById(Integer id) {
        storageRepository.deleteById(id);
    }


}

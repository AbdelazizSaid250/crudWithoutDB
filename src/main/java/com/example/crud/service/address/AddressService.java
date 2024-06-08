package com.example.crud.service.address;

import com.example.crud.model.dto.AddressDto;

import java.util.List;

public interface AddressService {

    void save(AddressDto addressDto);

    AddressDto findById(String id);

    List<AddressDto> findAll();

    void update(String id, AddressDto addressDto);

    void remove(String id);
}

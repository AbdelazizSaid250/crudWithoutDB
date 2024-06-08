package com.example.crud.service.address;

import com.example.crud.error.exception.StudentNotFoundException;
import com.example.crud.model.dto.AddressDto;
import com.example.crud.model.entity.Address;
import com.example.crud.repository.dao.jpa.address.AddressRepository;
import com.example.crud.util.transformation.StudentTransformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.crud.error.util.ErrorDescription.STUDENT_NOT_FOUND;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

    private static final String CLASS_NAME = AddressServiceImpl.class.getSimpleName();

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        log.info(CLASS_NAME);
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(AddressDto addressDto) {
        Address student = StudentTransformation.toAddress(addressDto);

        addressRepository.save(student);
    }

    @Override
    public AddressDto findById(String id) {
        return new AddressDto("", "", "");
    }

    @Override
    public List<AddressDto> findAll() {
        List<Address> students = addressRepository.findAll();
//        return students.stream().map(StudentTransformation::toStudentDto).toList();
        return new ArrayList<>();
    }

    @Override
    public void update(String id, AddressDto addressDto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND + id));

        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());

        addressRepository.save(address);
    }

    @Override
    public void remove(String id) {
        Address foundAddress = addressRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND + id));
        addressRepository.delete(foundAddress);
    }
}

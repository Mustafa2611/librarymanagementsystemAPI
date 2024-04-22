package com.BMS.librarymanagementsystem.librarymanagementsystem.service;

import com.BMS.librarymanagementsystem.librarymanagementsystem.exception.ResourceNotFoundException;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Patron;
import com.BMS.librarymanagementsystem.librarymanagementsystem.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(Long id) {
        Optional<Patron> optionalPatron = patronRepository.findById(id);
        return optionalPatron.orElseThrow(() -> new ResourceNotFoundException("Patron not found with id: " + id));
    }

    public Patron addPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron updatePatron(Long id, Patron patronDetails) {
        Optional<Patron> optionalPatron = patronRepository.findById(id);
        if (!optionalPatron.isPresent()) {
            throw new ResourceNotFoundException("Patron not found with id: " + id);
        }
        Patron patron = optionalPatron.get();
        patron.setName(patronDetails.getName());
        patron.setContactInformation(patronDetails.getContactInformation());
        return patronRepository.save(patron);
    }

    public void deletePatron(Long id) {
        Optional<Patron> optionalPatron = patronRepository.findById(id);
        if (!optionalPatron.isPresent()) {
            throw new ResourceNotFoundException("Patron not found with id: " + id);
        }
        patronRepository.deleteById(id);
    }
}

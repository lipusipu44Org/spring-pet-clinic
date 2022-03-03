package com.anilpatro044.springpetclinic.services.springdatajpa;

import com.anilpatro044.springpetclinic.model.Vet;
import com.anilpatro044.springpetclinic.repositories.VetRepository;
import com.anilpatro044.springpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class VetSDJpaService implements VetService {
    private VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets=new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        Optional<Vet> byId = vetRepository.findById(aLong);
        return byId.orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}

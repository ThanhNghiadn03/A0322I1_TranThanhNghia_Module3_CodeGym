package service.impl;

import model.BenhAn;
import model.BenhNhan;
import repository.BenhAnRepository;
import repository.BenhNhanRepository;
import repository.impl.BenhAnRepositoryImpl;
import service.BenhAnService;

import java.util.List;

public class BenhAnServiceImpl implements BenhAnService {
    BenhAnRepository benhAnRepository = new BenhAnRepositoryImpl();
    BenhNhanRepository benhNhanRepository = new BenhAnRepositoryImpl();

    @Override
    public List<BenhNhan> findAllBenhNhan() {
        return benhNhanRepository.findAllBenhNhan();
    }

    @Override
    public BenhNhan findBenhNhanById(int id) {
        return benhNhanRepository.findBenhNhanById(id);
    }

    @Override
    public List<BenhAn> findAll() {
        return benhAnRepository.findAll();
    }

    @Override
    public void insert(BenhAn benhAn) {
        benhAnRepository.insert(benhAn);
    }

    @Override
    public void edit(BenhAn benhAn) {
        benhAnRepository.edit(benhAn);
    }

    @Override
    public void deleteById(int id) {
        benhAnRepository.deleteById(id);
    }
}

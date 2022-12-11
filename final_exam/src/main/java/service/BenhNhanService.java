package service;

import model.BenhNhan;

import java.util.List;

public interface BenhNhanService {
    List<BenhNhan> findAllBenhNhan();
    BenhNhan findBenhNhanById(int id);
}

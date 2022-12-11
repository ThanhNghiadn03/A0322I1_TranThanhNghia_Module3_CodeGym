package repository;

import model.BenhNhan;

import java.util.List;

public interface BenhNhanRepository {
    List<BenhNhan> findAllBenhNhan();
    BenhNhan findBenhNhanById(int id);
}

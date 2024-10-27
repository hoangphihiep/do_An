package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.LichSuModel;

public interface ILichSuDatPhongService {

	List<LichSuModel> findByIdUser(int idUser);
}

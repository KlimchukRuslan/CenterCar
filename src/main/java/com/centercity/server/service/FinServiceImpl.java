package com.centercity.server.service;

import com.centercity.server.entity.FinDataUser;
import com.centercity.server.repository.FinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinServiceImpl implements FinService {

    @Autowired
    private FinRepository repository;

    public List<FinDataUser> getAll() {
        return repository.findAll();
    }
    public FinDataUser getByID(long id) {
        return repository.findById(id).get();
    }
    public FinDataUser save(FinDataUser fin_data) {
        return repository.saveAndFlush(fin_data);
    }
    public void remove(long id) {
        repository.deleteById(id);
    }
    public int validForm(FinDataUser car){
        return 0;
    }

    public boolean updateFin(FinDataUser finDataUser) {
        FinDataUser fin_data = repository.findById(finDataUser.getId()).get();
        fin_data.setVal(finDataUser.getVal());
        fin_data.setDop_dohod(finDataUser.getDop_dohod());
        fin_data.setToplivo(finDataUser.getToplivo());
        fin_data.setSum_val_dop_d_top(finDataUser.getSum_val_dop_d_top());
        fin_data.setPereplata_nal(finDataUser.getPereplata_nal());
        fin_data.setBonus(finDataUser.getBonus());
        fin_data.setSum_bonus(finDataUser.getSum_bonus());
        fin_data.setPred_week(finDataUser.getPred_week());
        fin_data.setPererashod(finDataUser.getPererashod());
        fin_data.setNedosdacha(finDataUser.getNedosdacha());
        fin_data.setMoyka(finDataUser.getMoyka());
        fin_data.setDate_avans(finDataUser.getDate_avans());
        fin_data.setAvans(finDataUser.getAvans());
        fin_data.setData_vyplaty(finDataUser.getData_vyplaty());
        fin_data.setVyplaty(finDataUser.getVyplaty());
        fin_data.setDrugoe(finDataUser.getDrugoe());
        fin_data.setSum_drugoe(finDataUser.getSum_drugoe());
        fin_data.setItogo(finDataUser.getItogo());
        fin_data.setShow(finDataUser.isShow());
        repository.save(fin_data);
        return true;
    }

    public void updateDate(FinDataUser finDataUser) {
        FinDataUser fin_data = repository.findById(finDataUser.getId()).get();
        fin_data.setDate(finDataUser.getDate());
        fin_data.setWeek(finDataUser.getWeek());
        fin_data.setDates(finDataUser.getDates());
        repository.save(fin_data);
    }
}

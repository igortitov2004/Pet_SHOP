package com.example.shop.services;

import com.example.shop.models.StaffModel;
import com.example.shop.repositories.StaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffService {
  private final StaffRepository staffRepository;
    public List<StaffModel> listStaffs(String fullName) {
       if(fullName!=null) return staffRepository.findStaffModelByFullNameContaining(fullName);
        return staffRepository.findAll();
    }
    public void saveStaff(StaffModel staff){
       staffRepository.save(staff);
    }
    public void update(Long id,StaffModel staffModel){
        StaffModel staff= getStaffById(id);
        staff.setFullName(staffModel.getFullName());
        staff.setNumOfPassport(staffModel.getNumOfPassport());
        staff.setTelNumber(staffModel.getTelNumber());
        staff.setExperience(staffModel.getExperience());
        staff.setJob_title(staffModel.getJob_title());
        staffRepository.save(staff);
    }
    public boolean isStaff(StaffModel staff){
        if(staffRepository.findByTelNumber(staff.getTelNumber())!=null ){
            return false;
        }
        return true;
    }

    public Optional<StaffModel> getStaffByNumOfPassport(String numOfPassport){
        return Optional.ofNullable(staffRepository.findStaffModelByNumOfPassport(numOfPassport));
    }
    public Optional<StaffModel> getStaffByTelNumber(String telNumber){
        return Optional.ofNullable(staffRepository.findStaffModelByTelNumber(telNumber));
    }
    public void deleteStaff( Long id_staff){
        staffRepository.deleteById(id_staff);
    }
    public StaffModel getStaffById(Long id_staff) {
        return staffRepository.findById(id_staff).orElse(null);
    }
}

package com.example.shop.repositories;

import com.example.shop.models.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StaffRepository extends JpaRepository<StaffModel,Long>{
   List<StaffModel> findStaffModelByFullNameContaining (String fullName);
   StaffModel findStaffModelByTelNumber(String tel_number);
   StaffModel findByTelNumber(String tel_number);

   StaffModel findStaffModelByNumOfPassport(String numOfPassport);

}

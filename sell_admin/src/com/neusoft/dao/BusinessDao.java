package com.neusoft.dao;

import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessDao {
   // 所有商家
   public List<Business> listBusiness(String businessName, String businessAddress);
   // 保存商家
   public int saveBusiness(Business business);
   // 删除商家
   public int removeBusiness(int businessId);
   //修改
   public int supdateBusiness(Business business);
   //通过ID查询
   public Business getBusinessById(Integer businessId);

   public Business getBusinessByIdAndPassword(Integer businessId, String password);

   public int updateBusinessPassword(Integer businessId,String password);
}

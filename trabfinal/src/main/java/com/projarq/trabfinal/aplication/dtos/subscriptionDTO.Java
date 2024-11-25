package com.projarq.trabfinal.aplication.dtos;

public class SubscriptionDTO {
     private long customerCode;
     private long appCode;

     public long getCustomerCode() {
          return customerCode;
      }
  
      public void setCustomerCode(long customerCode) {
          this.customerCode = customerCode;
      }
  
      public long getAppCode() {
          return appCode;
      }
  
      public void setAppCode(long appCode) {
          this.appCode = appCode;
      }
}


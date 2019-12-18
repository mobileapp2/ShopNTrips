package com.imuons.shopntrips.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WithdrawHistoryReportRecordModel {
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("request_id")
    @Expose
    private Integer requestId;
    @SerializedName("toUserId")
    @Expose
    private Integer toUserId;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("net_amount")
    @Expose
    private Double netAmount;
    @SerializedName("deduction")
    @Expose
    private Double deduction;
    @SerializedName("rec_date")
    @Expose
    private String recDate;
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("payout_no")
    @Expose
    private Integer payoutNo;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("tds")
    @Expose
    private Double tds;
    @SerializedName("amt_pin")
    @Expose
    private Double amtPin;
    @SerializedName("account_no")
    @Expose
    private Object accountNo;
    @SerializedName("holder_name")
    @Expose
    private Object holderName;
    @SerializedName("bank_name")
    @Expose
    private Object bankName;
    @SerializedName("branch_name")
    @Expose
    private Object branchName;
    @SerializedName("payment_mode")
    @Expose
    private Object paymentMode;
    @SerializedName("pan_no")
    @Expose
    private Object panNo;
    @SerializedName("ifsc_code")
    @Expose
    private Object ifscCode;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("withdraw_type")
    @Expose
    private String withdrawType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public Double getDeduction() {
        return deduction;
    }

    public void setDeduction(Double deduction) {
        this.deduction = deduction;
    }

    public String getRecDate() {
        return recDate;
    }

    public void setRecDate(String recDate) {
        this.recDate = recDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPayoutNo() {
        return payoutNo;
    }

    public void setPayoutNo(Integer payoutNo) {
        this.payoutNo = payoutNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTds() {
        return tds;
    }

    public void setTds(Double tds) {
        this.tds = tds;
    }

    public Double getAmtPin() {
        return amtPin;
    }

    public void setAmtPin(Double amtPin) {
        this.amtPin = amtPin;
    }

    public Object getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Object accountNo) {
        this.accountNo = accountNo;
    }

    public Object getHolderName() {
        return holderName;
    }

    public void setHolderName(Object holderName) {
        this.holderName = holderName;
    }

    public Object getBankName() {
        return bankName;
    }

    public void setBankName(Object bankName) {
        this.bankName = bankName;
    }

    public Object getBranchName() {
        return branchName;
    }

    public void setBranchName(Object branchName) {
        this.branchName = branchName;
    }

    public Object getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Object paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Object getPanNo() {
        return panNo;
    }

    public void setPanNo(Object panNo) {
        this.panNo = panNo;
    }

    public Object getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(Object ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(String withdrawType) {
        this.withdrawType = withdrawType;
    }

}

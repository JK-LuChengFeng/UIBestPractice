package com.example.uibestpractice.bean;

import java.util.List;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/5 17:16
 */
public class TestBean {


    /**
     * code : 1
     * msg : success
     * data : [{"subId":791,"subCode":"1001","subName":"库存现金","subLevel":null,"subAlias":null,"balanceDirection":null,"parentCode":null,"lowerSubjectStatus":"0","sealedStatus":null,"isAidAccount":"0","aidType":null,"isNumAccount":null,"calculationUnit":null,"isCurrencyAccount":null,"currencySymbol":null,"isAdjust":null,"categoryId":null,"categoryIds":null,"eleAtrbClsId":null,"eleAtrbClsName":null,"assistCategoryName":null,"currencyName":null,"chectName":null,"createTime":null,"createBy":null,"modifyTime":null,"modifyBy":null,"depositBank":null,"bankNo":null,"tenantId":null,"setBooksId":null,"deleteFlag":null,"ephemeralName":"库存现金","isAssAccount":null},[{"subId":1079,"subCode":"1002000001","subName":"新增","subLevel":null,"subAlias":null,"balanceDirection":null,"parentCode":"1002","lowerSubjectStatus":"0","sealedStatus":null,"isAidAccount":"0","aidType":null,"isNumAccount":null,"calculationUnit":null,"isCurrencyAccount":null,"currencySymbol":null,"isAdjust":null,"categoryId":null,"categoryIds":null,"eleAtrbClsId":null,"eleAtrbClsName":null,"assistCategoryName":null,"currencyName":null,"chectName":null,"createTime":null,"createBy":null,"modifyTime":null,"modifyBy":null,"depositBank":null,"bankNo":null,"tenantId":null,"setBooksId":null,"deleteFlag":null,"ephemeralName":"银行存款_新增","isAssAccount":null},{"subId":1084,"subCode":"1002000003","subName":"北京","subLevel":null,"subAlias":null,"balanceDirection":null,"parentCode":"1002","lowerSubjectStatus":"0","sealedStatus":null,"isAidAccount":"0","aidType":null,"isNumAccount":null,"calculationUnit":null,"isCurrencyAccount":null,"currencySymbol":null,"isAdjust":null,"categoryId":null,"categoryIds":null,"eleAtrbClsId":null,"eleAtrbClsName":null,"assistCategoryName":null,"currencyName":null,"chectName":null,"createTime":null,"createBy":null,"modifyTime":null,"modifyBy":null,"depositBank":null,"bankNo":null,"tenantId":null,"setBooksId":null,"deleteFlag":null,"ephemeralName":"银行存款_北京","isAssAccount":null}],{"subId":793,"subCode":"1003","subName":"存放中央银行款项","subLevel":null,"subAlias":null,"balanceDirection":null,"parentCode":null,"lowerSubjectStatus":"0","sealedStatus":null,"isAidAccount":"0","aidType":null,"isNumAccount":null,"calculationUnit":null,"isCurrencyAccount":null,"currencySymbol":null,"isAdjust":null,"categoryId":null,"categoryIds":null,"eleAtrbClsId":null,"eleAtrbClsName":null,"assistCategoryName":null,"currencyName":null,"chectName":null,"createTime":null,"createBy":null,"modifyTime":null,"modifyBy":null,"depositBank":null,"bankNo":null,"tenantId":null,"setBooksId":null,"deleteFlag":null,"ephemeralName":"存放中央银行款项","isAssAccount":null},[{"subId":16725,"subCode":"1015000001","subName":"美元","subLevel":null,"subAlias":null,"balanceDirection":null,"parentCode":"1015","lowerSubjectStatus":"0","sealedStatus":null,"isAidAccount":"0","aidType":"","isNumAccount":null,"calculationUnit":null,"isCurrencyAccount":null,"currencySymbol":null,"isAdjust":null,"categoryId":null,"categoryIds":null,"eleAtrbClsId":null,"eleAtrbClsName":null,"assistCategoryName":null,"currencyName":null,"chectName":null,"createTime":null,"createBy":null,"modifyTime":null,"modifyBy":null,"depositBank":null,"bankNo":null,"tenantId":null,"setBooksId":null,"deleteFlag":null,"ephemeralName":"其它货币资金_美元","isAssAccount":null}],[]]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * subId : 791
         * subCode : 1001
         * subName : 库存现金
         * subLevel : null
         * subAlias : null
         * balanceDirection : null
         * parentCode : null
         * lowerSubjectStatus : 0
         * sealedStatus : null
         * isAidAccount : 0
         * aidType : null
         * isNumAccount : null
         * calculationUnit : null
         * isCurrencyAccount : null
         * currencySymbol : null
         * isAdjust : null
         * categoryId : null
         * categoryIds : null
         * eleAtrbClsId : null
         * eleAtrbClsName : null
         * assistCategoryName : null
         * currencyName : null
         * chectName : null
         * createTime : null
         * createBy : null
         * modifyTime : null
         * modifyBy : null
         * depositBank : null
         * bankNo : null
         * tenantId : null
         * setBooksId : null
         * deleteFlag : null
         * ephemeralName : 库存现金
         * isAssAccount : null
         */

        private int subId;
        private String subCode;
        private String subName;
        private Object subLevel;
        private Object subAlias;
        private Object balanceDirection;
        private Object parentCode;
        private String lowerSubjectStatus;
        private Object sealedStatus;
        private String isAidAccount;
        private Object aidType;
        private Object isNumAccount;
        private Object calculationUnit;
        private Object isCurrencyAccount;
        private Object currencySymbol;
        private Object isAdjust;
        private Object categoryId;
        private Object categoryIds;
        private Object eleAtrbClsId;
        private Object eleAtrbClsName;
        private Object assistCategoryName;
        private Object currencyName;
        private Object chectName;
        private Object createTime;
        private Object createBy;
        private Object modifyTime;
        private Object modifyBy;
        private Object depositBank;
        private Object bankNo;
        private Object tenantId;
        private Object setBooksId;
        private Object deleteFlag;
        private String ephemeralName;
        private Object isAssAccount;

        public int getSubId() {
            return subId;
        }

        public void setSubId(int subId) {
            this.subId = subId;
        }

        public String getSubCode() {
            return subCode;
        }

        public void setSubCode(String subCode) {
            this.subCode = subCode;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public Object getSubLevel() {
            return subLevel;
        }

        public void setSubLevel(Object subLevel) {
            this.subLevel = subLevel;
        }

        public Object getSubAlias() {
            return subAlias;
        }

        public void setSubAlias(Object subAlias) {
            this.subAlias = subAlias;
        }

        public Object getBalanceDirection() {
            return balanceDirection;
        }

        public void setBalanceDirection(Object balanceDirection) {
            this.balanceDirection = balanceDirection;
        }

        public Object getParentCode() {
            return parentCode;
        }

        public void setParentCode(Object parentCode) {
            this.parentCode = parentCode;
        }

        public String getLowerSubjectStatus() {
            return lowerSubjectStatus;
        }

        public void setLowerSubjectStatus(String lowerSubjectStatus) {
            this.lowerSubjectStatus = lowerSubjectStatus;
        }

        public Object getSealedStatus() {
            return sealedStatus;
        }

        public void setSealedStatus(Object sealedStatus) {
            this.sealedStatus = sealedStatus;
        }

        public String getIsAidAccount() {
            return isAidAccount;
        }

        public void setIsAidAccount(String isAidAccount) {
            this.isAidAccount = isAidAccount;
        }

        public Object getAidType() {
            return aidType;
        }

        public void setAidType(Object aidType) {
            this.aidType = aidType;
        }

        public Object getIsNumAccount() {
            return isNumAccount;
        }

        public void setIsNumAccount(Object isNumAccount) {
            this.isNumAccount = isNumAccount;
        }

        public Object getCalculationUnit() {
            return calculationUnit;
        }

        public void setCalculationUnit(Object calculationUnit) {
            this.calculationUnit = calculationUnit;
        }

        public Object getIsCurrencyAccount() {
            return isCurrencyAccount;
        }

        public void setIsCurrencyAccount(Object isCurrencyAccount) {
            this.isCurrencyAccount = isCurrencyAccount;
        }

        public Object getCurrencySymbol() {
            return currencySymbol;
        }

        public void setCurrencySymbol(Object currencySymbol) {
            this.currencySymbol = currencySymbol;
        }

        public Object getIsAdjust() {
            return isAdjust;
        }

        public void setIsAdjust(Object isAdjust) {
            this.isAdjust = isAdjust;
        }

        public Object getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Object categoryId) {
            this.categoryId = categoryId;
        }

        public Object getCategoryIds() {
            return categoryIds;
        }

        public void setCategoryIds(Object categoryIds) {
            this.categoryIds = categoryIds;
        }

        public Object getEleAtrbClsId() {
            return eleAtrbClsId;
        }

        public void setEleAtrbClsId(Object eleAtrbClsId) {
            this.eleAtrbClsId = eleAtrbClsId;
        }

        public Object getEleAtrbClsName() {
            return eleAtrbClsName;
        }

        public void setEleAtrbClsName(Object eleAtrbClsName) {
            this.eleAtrbClsName = eleAtrbClsName;
        }

        public Object getAssistCategoryName() {
            return assistCategoryName;
        }

        public void setAssistCategoryName(Object assistCategoryName) {
            this.assistCategoryName = assistCategoryName;
        }

        public Object getCurrencyName() {
            return currencyName;
        }

        public void setCurrencyName(Object currencyName) {
            this.currencyName = currencyName;
        }

        public Object getChectName() {
            return chectName;
        }

        public void setChectName(Object chectName) {
            this.chectName = chectName;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public Object getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(Object modifyTime) {
            this.modifyTime = modifyTime;
        }

        public Object getModifyBy() {
            return modifyBy;
        }

        public void setModifyBy(Object modifyBy) {
            this.modifyBy = modifyBy;
        }

        public Object getDepositBank() {
            return depositBank;
        }

        public void setDepositBank(Object depositBank) {
            this.depositBank = depositBank;
        }

        public Object getBankNo() {
            return bankNo;
        }

        public void setBankNo(Object bankNo) {
            this.bankNo = bankNo;
        }

        public Object getTenantId() {
            return tenantId;
        }

        public void setTenantId(Object tenantId) {
            this.tenantId = tenantId;
        }

        public Object getSetBooksId() {
            return setBooksId;
        }

        public void setSetBooksId(Object setBooksId) {
            this.setBooksId = setBooksId;
        }

        public Object getDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(Object deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public String getEphemeralName() {
            return ephemeralName;
        }

        public void setEphemeralName(String ephemeralName) {
            this.ephemeralName = ephemeralName;
        }

        public Object getIsAssAccount() {
            return isAssAccount;
        }

        public void setIsAssAccount(Object isAssAccount) {
            this.isAssAccount = isAssAccount;
        }
    }
}

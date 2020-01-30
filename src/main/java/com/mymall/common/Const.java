package com.mymall.common;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Set;

public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface ProductListOrderBy{
        Set<String> PRICE_ASE_DESC = Sets.newHashSet("price_desc","price_asc");
    }

    public interface Cart{
        int CHECKED = 1;
        int UN_CHECKED = 0;

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }

    public interface Role{
        int ROLE_CUSTOMER = 0;//User
        int ROLE_ADMIN = 1;//Administrator
    }

    public enum ProductStatusEnum{
        ON_SALE(1,"On sale");

        private String value;
        private int code;
        ProductStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum OrderStatusEnum{
        CANCELED(0,"Order canceled."),
        UNPAIED(10,"Unpaied."),
        PAIED(20,"Paied."),
        SHIPPED(40,"Order shipped."),
        ORDER_SUCCEED(50,"Order finished."),
        ORDER_CLOSSED(60,"Order clossed.");

        OrderStatusEnum(int code,String value){
            this.code=code;
            this.value=value;
        }
        private  String value;
        private int code;
        public String getValue() {
            return value;
        }
        public int getCode() {
            return code;
        }

        public static OrderStatusEnum codeOf(int code){
            for(OrderStatusEnum orderStatusEnum : values()){
                if(orderStatusEnum.getCode() == code){
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("Do not found enumerate.");
        }
    }

    public interface AlipayCallback{
        String TRADE_STATUS_WAIT_BAYER_PAY = "WAIT_BAYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }

    public enum PayPlatformEnum{
        ALIPAY(1,"Alipay");


        PayPlatformEnum(int code,String value){
            this.code=code;
            this.value=value;
        }

        private  String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PaymentTypeEnum{
        ONLINE_PAY(1,"Online payment.");

        PaymentTypeEnum(int code,String value){
            this.code=code;
            this.value=value;
        }

        private  String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static PaymentTypeEnum codeOf(int code){
            for(PaymentTypeEnum paymentTypeEnum : values()){
                if(paymentTypeEnum.getCode() == code){
                    return paymentTypeEnum;
                }
            }
            throw new RuntimeException("Do not found enumerate.");
        }
    }

}

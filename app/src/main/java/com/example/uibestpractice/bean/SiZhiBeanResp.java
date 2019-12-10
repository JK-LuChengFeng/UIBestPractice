package com.example.uibestpractice.bean;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/5 15:13
 */
public class SiZhiBeanResp {


    /**
     * message : success
     * data : {"type":5000,"info":{"text":"姚明的身高是226厘米"}}
     */

    private String message;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : 5000
         * info : {"text":"姚明的身高是226厘米"}
         */

        private int type;
        private InfoBean info;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * text : 姚明的身高是226厘米
             */

            private String text;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}

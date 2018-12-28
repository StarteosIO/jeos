package io.starteos.jeos.net.response;

import java.util.List;

public class BaseResponse{


    /**
     * core : 500
     * message : Internal Service Error
     * error : {"core":3010001,"name":"name_type_exception","what":"Invalid name","details":[{"message":"Name is longer than 13 characters (\t\n11111vs22222) ","file":"name.cpp","line_number":11,"method":"set"}]}
     */
    private Integer code = null;
    private String message;
    private ErrorBean error;

    public boolean isError() {
        return error != null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public static class ErrorBean {
        /**
         * core : 3010001
         * name : name_type_exception
         * what : Invalid name
         * details : [{"message":"Name is longer than 13 characters (\t\n11111vs22222) ","file":"name.cpp","line_number":11,"method":"set"}]
         */

        private int code;
        private String name;
        private String what;
        private List<DetailsBean> details;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWhat() {
            return what;
        }

        public void setWhat(String what) {
            this.what = what;
        }

        public List<DetailsBean> getDetails() {
            return details;
        }

        public void setDetails(List<DetailsBean> details) {
            this.details = details;
        }

        public static class DetailsBean {
            /**
             * message : Name is longer than 13 characters (
             * 11111vs22222)
             * file : name.cpp
             * line_number : 11
             * method : set
             */

            private String message;
            private String file;
            private int line_number;
            private String method;

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getFile() {
                return file;
            }

            public void setFile(String file) {
                this.file = file;
            }

            public int getLine_number() {
                return line_number;
            }

            public void setLine_number(int line_number) {
                this.line_number = line_number;
            }

            public String getMethod() {
                return method;
            }

            public void setMethod(String method) {
                this.method = method;
            }

            @Override
            public String toString() {
                return "DetailsBean{" +
                        "message='" + message + '\'' +
                        ", file='" + file + '\'' +
                        ", line_number=" + line_number +
                        ", method='" + method + '\'' +
                        '}';
            }
        }
    }
}

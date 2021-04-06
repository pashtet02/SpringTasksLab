package com.example.task1.others;

import org.springframework.stereotype.Component;

    @Component
    public class OtherBeanC {
        private String otherName;

        public String getOtherName() {
            return otherName;
        }

        public void setOtherName(String otherName) {
            this.otherName = otherName;
        }

        public OtherBeanC(String otherName) {
            this.otherName = otherName;
        }

        public OtherBeanC() {
        }
    }
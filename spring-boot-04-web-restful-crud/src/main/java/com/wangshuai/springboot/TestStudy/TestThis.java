package com.wangshuai.springboot.TestStudy;

public class TestThis {
        private int p1=2;
        private int p2;
        private int p3;
        public void SoutP1(){
            p1 = 3;
            System.out.println(this.p1);
            System.out.println(p1);
            System.out.println(this.p1);
        }

        public int getP1() {
            return p1;
        }

        public void setP1(int p1) {
            this.p1 = p1;
        }

        public int getP2() {
            return p2;
        }

        public void setP2(int p2) {
            this.p2 = p2;
        }

        public int getP3() {
            return p3;
        }

        public void setP3(int p3) {
            this.p3 = p3;
        }
}

package com.arun.scaler.practice.bits;

public class AddTwoBinaryNumbers {
    public static void main(String[] args) {
        System.out.println(
addBinary("1010110111001101101000","1000011011000000111100110"));

    }
        public static String addBinary(String A, String B) {
            if(A.length() > B.length()){
                B = addzeros(A.length() - B.length(), B);
            } else {
                A = addzeros(B.length() - A.length(), A);
            }

            String r = "";
            int c = 0;

            for(int i = A.length() -1;i>=0;i--){
                int res = Integer.parseInt(String.valueOf(A.charAt(i))) + Integer.parseInt(String.valueOf(B.charAt(i))) + c;
                r = String.valueOf(res%2) + r;
                c = res /2;
            }

            if(c == 1){
                r=  "1" + r;
            }
            return r;
        }

        public static String addzeros(int len, String a){
            for(int i = 0;i<len;i++){
                a = "0" + a;
            }
            return a;
        }
    }


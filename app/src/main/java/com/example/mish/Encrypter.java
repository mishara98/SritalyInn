package com.example.mish;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Base64;

public class Encrypter {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String caesarCipherEncrypt(String plain) {
        String b64encoded = Base64.getEncoder().encodeToString(plain.getBytes());

        // Reverse the string
        String reverse = new StringBuffer(b64encoded).reverse().toString();

        StringBuilder tmp = new StringBuilder();
        final int OFFSET = 4;
        for (int i = 0; i < reverse.length(); i++) {
            tmp.append((char)(reverse.charAt(i) + OFFSET));
        }
        return tmp.toString();
    }
}


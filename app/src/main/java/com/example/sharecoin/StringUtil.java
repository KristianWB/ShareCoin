package com.example.sharecoin;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.security.Key;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class StringUtil
{
    public static String applySha256(String input){

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            //Applies sha256 to our input,

            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal

            for (int i = 0; i < hash.length; i++) {

                String hex = Integer.toHexString(0xff & hash[i]);

                if(hex.length() == 1) hexString.append('0');

                hexString.append(hex);

            }

            return hexString.toString();

        }

        catch(Exception e) {

            throw new RuntimeException(e);

        }

    }

    public static byte[] applyECDSASig(PrivateKey privateKey, String input) {

        Signature dsa;

        byte[] output = new byte[0];

        try {

            dsa = Signature.getInstance("ECDSA", "BC");

            dsa.initSign(privateKey);

            byte[] strByte = input.getBytes();

            dsa.update(strByte);

            byte[] realSig = dsa.sign();

            output = realSig;

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

        return output;

    }



    //Verifies a String signature

    public static boolean verifyECDSASig(PublicKey publicKey, String data, byte[] signature) {

        try {

            Signature ecdsaVerify = Signature.getInstance("ECDSA", "BC");

            ecdsaVerify.initVerify(publicKey);

            ecdsaVerify.update(data.getBytes());

            return ecdsaVerify.verify(signature);

        }catch(Exception e) {

            throw new RuntimeException(e);

        }

    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getStringFromKey(Key key) {

        return Base64.getEncoder().encodeToString(key.getEncoded());

    }


    public void generateSignature(PrivateKey privateKey) {

        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value)	;

        signature = StringUtil.applyECDSASig(privateKey,data);

    }

//Verifies the data we signed hasnt been tampered with

    public boolean verifiySignature() {

        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value)	;

        return StringUtil.verifyECDSASig(sender, data, signature);

    }

    public static String getStringFromKey(PublicKey sender) {
    }
}

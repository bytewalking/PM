package com.suda.zph.passwordmanager;

import com.suda.zph.passwordmanager.security.AES;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void testFind(){
        String temp = new AES().AESencryption("1266sd342fsdf332dsfa312sdfgsdfg3123sdfsd232sdf4141414");
        System.out.println("temp:"+temp);

        String pass = new AES().AESdecode(temp);
        System.out.println("pass:"+pass);
    }
}
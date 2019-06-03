package com.example.sharecoin;

import static org.junit.Assert.*;

public class BlockTestB
{
    Block nyBlock=new Block("test");

    public void testData()
    {
        assertArrayEquals("test",nyBlock.getData());
    }

}

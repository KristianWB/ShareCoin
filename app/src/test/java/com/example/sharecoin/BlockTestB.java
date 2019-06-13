package com.example.sharecoin;

import static org.junit.Assert.*;

public class BlockTestB
{
    Block nyBlock=new Block("test");

    public void testData()
    {
        assertEquals("test",nyBlock.getData());
    }

}

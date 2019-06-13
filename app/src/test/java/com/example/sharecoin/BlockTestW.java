package com.example.sharecoin;



import static org.junit.Assert.*;

public class BlockTestW
{
    Block nyBlock=new Block("data");

    public void testData()
    {
        assertEquals("data",nyBlock.getData());
    }

}

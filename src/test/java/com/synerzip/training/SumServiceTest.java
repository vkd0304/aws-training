package com.synerzip.training;

import junit.framework.TestCase;

public class SumServiceTest extends TestCase
{

    public SumServiceTest(String name)
    {
        super(name);
    }

    protected void setUp() throws Exception
    {
        super.setUp();
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    public void testSum1()
    {
        double a = 10d;
        double b = 10d;
        double sum = SumService.sum(a, b);
        
        assertEquals(20d, sum);
    }
    
    public void testSum2()
    {
        double a = 10d;
        double b = 20d;
        double sum = SumService.sum(a, b);
        
        assertEquals(30d, sum);
    }

}

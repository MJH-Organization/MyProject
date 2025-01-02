package com.sist.math;

public class SingleTon {

    private static SingleTon si;
    
    public SingleTon()
    {
        
    }
    
    public static SingleTon newInstance()
    {
        if (si==null)
        {
            si=new SingleTon();
        }
        
        return si;
    }
}

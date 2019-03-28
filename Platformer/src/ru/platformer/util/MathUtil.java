package ru.platformer.util;

public final class MathUtil 
{
	private MathUtil() {}
	
	public static int integer(double d)
	{
		return (int) d;
	}
	
	public static int integer(float f)
	{
		return (int) f;
	}
	
	public static double frac(double d)
	{
		return d - (int) d;
	}
	
	public static float fract(float f)
	{
		return f - (int) f;
	}
	
	public static boolean isFloatNumber(double d)
	{
		return (int) d != d;
	}
	
	public static int roughRound(float f)
	{
		int r = (int) f;
		
		return r != f ? r + 1 : r; 
	}
	
	public static int roughRound(double d)
	{
		int r = (int) d;
		
		return r != d ? r + 1 : r; 
	}
}

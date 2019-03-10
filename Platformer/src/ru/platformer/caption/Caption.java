package ru.platformer.caption;

import java.io.Serializable;
import java.util.Arrays;

public final class Caption implements CharSequence, Cloneable, Serializable
{
	private static final long serialVersionUID = -6974376505010683876L;
	
	private char[] data;
	
	public Caption(String s)
	{
		data = s.toCharArray();
	}
	
	public Caption()
	{
		data = new char[0];
	}
	
	public Caption(char... data)
	{
		this.data = data;
	}
	
	public int length() 
	{
		return data.length;
	}

	public char charAt(int index) 
	{
		indexCheck0(index);
		
		return data[index];
	}

	public CharSequence subSequence(int start, int end) 
	{
		return subCaption(start, end);
	}
	
	public Caption toLowerCase() 
	{	
		for (int i = 0; i < data.length; ++i)
        	data[i] = Character.toLowerCase(data[i]);
        
        return this;
    }
	
	public Caption toUpperCase() 
	{	
		for (int i = 0; i < data.length; ++i)
        	data[i] = Character.toUpperCase(data[i]);
        
        return this;
    }
	
	public Caption removeLeadingWhitespaces()
	{
		int i = 0, length = data.length, lead = 0;
		
		for (i = 0; i < length; ++i)
		{
			if (isWhitespaceAt(i))
				++lead;
			else
				break;
		}
		
		data = Arrays.copyOfRange(data, lead, length);
		
		return this;
	}
	
	public Caption removeTrailingWhitespaces()
	{
		int i = 0, length = data.length, trail = 0;
		
		for (i = length - 1; i >= 0; --i)
		{
			if (isWhitespaceAt(i))
				++trail;
			else
				break;
		}
		
		data = Arrays.copyOfRange(data, 0, length - trail);
		
		return this;
	}
	
	public Caption trim()
	{
		return removeLeadingWhitespaces().removeTrailingWhitespaces();
	}
	
	public Caption clearWhitespaces()
	{
		int i = 0, j = 0, len = 0;
		
		for (i = 0; i < data.length; ++i)
		{
			if (!isWhitespaceAt(i))
				++len;
		}
		
		char[] data2 = new char[len];
		
		for (i = 0; i < data.length; ++i)
		{
			if (!isWhitespaceAt(i))
				data2[j++] = data[i];
		}
		
		data = data2.clone();
		data2 = null;
		
		return this;
	}
	
	public boolean isWhitespaceAt(int index)
	{
		indexCheck0(index);
		
		return Character.isWhitespace(codePointAt(index));
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Caption)
		{
			Caption cap = (Caption) o;
			int len = length();
			
			if (len == cap.length())
			{	
				int i = 0;
				
				for (i = 0; i < len; ++i)
				{
					if (data[i] != cap.data[i])
					{
						cap = null;
						i = 0;
						len = 0;
						
						return false;
					}
				}
				
				cap = null;
				i = 0;
				len = 0;
				
				return true;
			}
		}
		
		return false;
	}

	public Caption subCaption(int start)
	{
		indexCheck(start);
		
		data = Arrays.copyOfRange(data, start, data.length);
		
		return this;
	}
	
	public Caption clone()
	{
		Caption clone = new Caption();
		
		clone.data = this.data;
		
		return clone;
	}
	
	public Caption subCaption(int start, int end)
	{
		if (start > end)
		
		indexCheck(start);
		indexCheck(end);
		
		subCaption(start);
		data = Arrays.copyOfRange(data, 0, end);
		
		return this;
	}
	
	public Caption cutCaptionAtEnd(int endCutting)
	{
		indexCheck(endCutting);
			
		data = Arrays.copyOfRange(data, 0, length() - endCutting);
		
		return this;
	}
	
	public int codePointAt(int index) 
	{
        indexCheck0(index);
        
        return (int) data[index];
    }
	
	public Caption append(Object o)
	{
		return append(o.toString());
	}
	
	public Caption append(Caption cap)
	{
		return append(cap.data);
	}
	
	public Caption append(CharSequence cs)
	{
		char[] data2 = new char[cs.length()];
		
		for (int i = 0; i < data2.length; ++i)
			data2[i] = cs.charAt(i);
		
		return append(data2);
	}
	
	public Caption append(final char... data2)
	{
		int temp = data.length + data2.length;
		char[] newData = new char[temp];
		
		temp = data.length;
		
		int i = 0;
		
		for (i = 0; i < temp; ++i)
			newData[i] = data[i];
		for (i = 0; i < data2.length; ++i)
			newData[temp + i] = data2[i];
		
		data = newData;
		newData = null;
		
		return this;
	}
	
	private void indexCheck0(int index)
	{
		if ((index < 0) || (index >= data.length)) 
	        throw new CaptionIndexOutOfBoundsException(index);
	}
	
	private void indexCheck(int index)
	{
		if ((index < 0) || (index > data.length)) 
	        throw new CaptionIndexOutOfBoundsException(index);
	}
	
	public String toString()
	{
		return String.valueOf(data);
	}
	
	public static Caption emptyCaption()
	{
		return new Caption();
	}
	
	public static Caption valueOf(String s)
	{
		return new Caption(s);
	}
	
	public static Caption valueOf(char[] data)
	{
		return new Caption(data);
	}
	
	public static Caption valueOf(char c)
	{
		return new Caption(c);
	}
	
	public static Caption valueOf(boolean b)
	{
		return new Caption(b ? "true" : "false");
	}
	
	public static Caption valueOf(byte b)
	{
		return new Caption(String.valueOf(b));
	}
	
	public static Caption valueOf(short s)
	{
		return new Caption(String.valueOf(s));
	}
	
	public static Caption valueOf(int i)
	{
		return new Caption(String.valueOf(i));
	}
	
	public static Caption valueOf(long l)
	{
		return new Caption(String.valueOf(l));
	}
	
	public static Caption valueOf(float f)
	{
		return new Caption(String.valueOf(f));
	}
	
	public static Caption valueOf(double d)
	{
		return new Caption(String.valueOf(d));
	}
	
	public static Caption valueOf(Object o)
	{
		return new Caption(o == null ? "null" : o.toString());
	}
	
	public static class CaptionIndexOutOfBoundsException extends IndexOutOfBoundsException
	{
		private static final long serialVersionUID = 3290468852517586805L;

		public CaptionIndexOutOfBoundsException()
		{
			super();
		}
		
		public CaptionIndexOutOfBoundsException(String s)
		{
			super(s);
		}
		
		public CaptionIndexOutOfBoundsException(Caption c)
		{
			super(c.toString());
		}
		
		public CaptionIndexOutOfBoundsException(int index)
		{
			this(valueOf("Caption index out of range: ").append(index));
		}
	}
}

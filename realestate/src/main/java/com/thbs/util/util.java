package com.thbs.util;

import java.util.Base64;

public class util {

	  public String getImgData(byte[] byteData) {
	        return Base64.getMimeEncoder().encodeToString(byteData);
	        	
	    }
	  
}

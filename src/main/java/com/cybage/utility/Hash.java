package com.cybage.utility;

//import org.apache.tomcat.util.digester.Digester;

import org.apache.commons.codec.digest.DigestUtils;

//import java.nio.charset.StandardCharsets;

//import org.apache.commons.codec.digest.DigestUtils;

//import com.google.common.hash.Hashing;

public class Hash {
public static String getHash(String string) {
	return  DigestUtils.sha256Hex(string);
//	return "";
//return new DigestUtils("SHA3-256").digestAsHex(string);
}

public static void main(String []args) {
	//0e8dd50403ecb951aff7ecfad8bee109e3717db89e362f19a5890fa46efff261
	//3c6e6023c4c72e910468c1dbe2ce7388cf37c8c86776985a84de0d29b91449f5
	System.out.println(getHash("0e8dd50403ecb951aff7ecfad8bee109e3717db89e362f19a5890fa46efff261"));
	System.out.println( getHash("Event@123").contentEquals("3c6e6023c4c72e910468c1dbe2ce7388cf37c8c86776985a84de0d29b91449f5"));
	 System.out.println( getHash("Admin@123").equals("e86f78a8a3caf0b60d8e74e5942aa6d86dc150cd3c03338aef25b7d2d7e3acc7"));
	 
}
}

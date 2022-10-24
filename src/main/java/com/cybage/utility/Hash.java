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

}

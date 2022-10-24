package com.cybage.utility;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class Hash {
public static String getHash(String string) {
	return  Hashing.sha256()
			  .hashString(string, StandardCharsets.UTF_8)
			  .toString();
}
}

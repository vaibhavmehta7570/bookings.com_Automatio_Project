package webelement;

import org.apache.commons.codec.binary.Base64;

public class passworddecoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String orig="vaibhav";
		byte[] encode=Base64.encodeBase64(orig.getBytes());
		System.out.println(orig);
		System.out.println("encoded string->"+new String(encode));
		byte[] decode=Base64.decodeBase64(encode);
		System.out.println("decoded string"+new String(decode));
		
	}

}

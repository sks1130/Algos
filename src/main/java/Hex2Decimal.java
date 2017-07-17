public class Hex2Decimal {

    public static int hex2Decimal(String s) {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }


    // precondition:  d is a nonnegative integer
    public static String decimal2Hex(int d) {
        String digits = "0123456789ABCDEF";
        if (d == 0) return "0";
        String hex = "";
        while (d > 0) {
            int digit = d % 16;                // rightmost digit
            hex = digits.charAt(digit) + hex;  // string concatenation
            d = d / 16;
        }
        return hex;
    }
    public static String intToBinary(int n)
    {
        String s = "";
        if(n == 0){
        	return 0 + "";
        }
        while (n > 0)
        {
            s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
            n = n / 2;
        }
        return s;
    }
    public static String HEX_CHARACTERS="0123456789ABCDEF";

    private static int hex2dec(String hexValue) {
    	        hexValue = hexValue.toUpperCase();
    	        int decimalResult = 0;
    	        for(int i=0;i<hexValue.length();i++) {
    	            char digit = hexValue.charAt(i);
    	            int digitValue = HEX_CHARACTERS.indexOf(digit);
    	            decimalResult = decimalResult*16+digitValue;
    	        }
    	        return decimalResult;
    	    }

    public static void main(String[] args) {
        
    	for (int i = 0; i < 256; i++) {
			
    		//System.out.println("Binary eqivalent of i =" + i + " is " +intToBinary(i));
    		System.out.println("Binary eqivalent of i =" + i + " is " + Integer.toBinaryString(i));
    		System.out.println("Hexa eqivalent of i =" + i + " is " + Integer.toHexString(i));
		}
        
    	System.out.println("hexa abc=" + hex2dec("abc") + " and cba=" + hex2dec("cba") + " and bac=" + hex2dec("bac"));
    }
}
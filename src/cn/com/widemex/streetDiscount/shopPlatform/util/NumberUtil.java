package cn.com.widemex.streetDiscount.shopPlatform.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class NumberUtil {

	public static double get2Decimal(double number){
		NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        return Double.valueOf(nf.format(number));
	}
	
	
	public static void main(String[] args){
		System.out.println(get2Decimal(1.553));
		System.out.println(new BigDecimal(""));
	}
	
}

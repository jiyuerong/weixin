package cn.com.widemex.streetDiscount.shopPlatform.extend;

import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class RegexpLikeOracleDialect extends Oracle10gDialect {
	
	public RegexpLikeOracleDialect() { 
        super(); 
 
        registerFunction("regexp_like", new SQLFunctionTemplate( 
        		StandardBasicTypes.BOOLEAN, 
                "(case when (regexp_like(?1, ?2, 'i')) then 1 else 0 end)")); 
    } 

}

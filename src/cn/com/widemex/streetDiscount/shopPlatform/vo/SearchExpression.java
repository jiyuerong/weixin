package cn.com.widemex.streetDiscount.shopPlatform.vo;

public class SearchExpression {
	
	private String field;
	
	private Object word;
	
	private String operator;
	
	private String relation;
	
	public SearchExpression(String field, Object word, String operator, String relation){
		
		this.field = field;
		this.word = word;
		this.operator = operator;
		this.relation = relation;
	}
	
    public SearchExpression(String field, Object word, String operator){
		
		this(field, word, operator, "");
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getWord() {
		return word;
	}

	public void setWord(Object word) {
		this.word = word;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	

}

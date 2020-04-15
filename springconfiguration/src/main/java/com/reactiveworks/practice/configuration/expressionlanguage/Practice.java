package com.reactiveworks.practice.configuration.expressionlanguage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Practice {

	@Value("#{ 1 + 2}")
	private int sum;

	@Value("#{'12235' matches '\\d+' }")
	boolean isValid;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "Practice [sum=" + sum + ", isValid=" + isValid + "]";
	}

}

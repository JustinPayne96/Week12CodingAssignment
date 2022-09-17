package week12DemoTest;

import java.util.Random;

public class TestDemo {

	
	public int addPositive(int a, int b) {
		if(a < 1 || b < 1) {
			throw new IllegalArgumentException("Both paramaters must be positive!");
		}
			return a + b;
	}

	public int randomNumberSquared() {
		int random = getRandomInt();
		return random * random;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}


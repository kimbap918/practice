package ex01;

class Tv2 {
	boolean power;
	int channel;
	
	void power()	{ power = !power; }
	void channelUp()	{ ++channel; }
	void channelDown() { --channel; }
}

class VCR {
	boolean power;
	int counter = 0;
	void power() {	power = !power; }
	void play() { /* 생략 */ }
	void stop() { /* 생략 */ }
	void rew() { /* 생략 */ }
	void ff() { /* 생략 */ }
}

public class TVCR extends Tv2 {
		VCR vcr = new VCR();
		int counter = vcr.counter;
		
		void play() {
			vcr.play();
		}
		
		void stop() {
			vcr.stop();
		}
		
		void rew() {
			vcr.rew();
		}
		
		void ff() {
			vcr.ff();
		}
}


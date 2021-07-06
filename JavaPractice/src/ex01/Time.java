package ex01;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public int getHour() {return hour;}
	public int getMinute() {return minute;}
	public int getSecond() {return second;}
	
	public void setHour(int h) {
		if(h < 0 || h > 23) return;
		hour=h;
	}
	
	public void setMinute(int m) {
		if(m < 0 || m > 59) return;
		minute=m;
	}
	
	public void setSecond(int s) {
		if(s < 0.0f || s > 59.9) return;
		second=s;
	}
	}



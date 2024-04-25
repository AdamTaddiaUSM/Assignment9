package accidentpack;

import java.util.GregorianCalendar;
import java.util.Scanner;


public class Report implements Comparable<Report>{
	//DECEMBER 21 = winter start MARCH 21 = winter end
	private MyDate date;
	private String ID;
	private int severity;
	private int startTime[] = new int[6]; //year,month,day,hour,minute,second
	private int endTime[] = new int[6]; //year,month,day,hour,minute,second
	private int startTimeAsSeconds = 0;//seconds passed the beginning of 2021, because that's the earliest date
	private int endTimeAsSeconds = 0;
	private String street;
	private String city;
	private String county;
	private String state;
	private double temperature;	//fahrenheit
	private double humidity;	//as %
	private double visibility;	//miles
	private String weather;
	private boolean atCrossing;	//true = yes, at a crossing; false = no, not at crossing
	private boolean isDay;	//true = Day, false = Night
	
	public MyDate getDate() {
		return this.date;
	}
	
	public void setDate(MyDate date) {
		this.date = date;
	}
	
	public String getID() {
		return ID;
	}
	
	//these are all just setter and getter methods. None of the setters are used so far.
	public void setID(String iD) {
		ID = iD;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public int[] getStartTime() {
		return startTime;
	}
	public void setStartTime(int[] startTime) {
		this.startTime = startTime;
	}
	public int[] getEndTime() {
		return endTime;
	}
	public void setEndTime(int[] endTime) {
		this.endTime = endTime;
	}
	public int getStartTimeAsSeconds() {
		return startTimeAsSeconds;
	}
	public void setStartTimeAsSeconds(int time) {
		this.startTimeAsSeconds = time;
	}
	public int getEndTimeAsSeconds() {
		return endTimeAsSeconds;
	}
	public void setEndTimeAsSeconds(int time) {
		this.endTimeAsSeconds = time;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getVisibility() {
		return visibility;
	}
	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public boolean isAtCrossing() {
		return atCrossing;
	}
	public void setAtCrossing(boolean atCrossing) {
		this.atCrossing = atCrossing;
	}
	public boolean isDay() {
		return isDay;
	}
	public void setDay(boolean isDay) {
		this.isDay = isDay;
	}
	
	public int compareStartTimes(Report r2) {
		if (this.date.year != r2.date.year) {
			return this.date.year = r2.date.year;
		} else if (this.date.month != r2.date.month) {
			return this.date.month = r2.date.month;
		} else if (this.date.day != r2.date.day) {
			return this.date.day = r2.date.day;
		} else {
			return 0;
		}
		
	}
	
	public int compareTo(Report r2) {
		return this.date.compareTo(r2.date);
		
	}
	/**
	 * prints out all of the variables of a report. Order of 1
	 */
	public void print() {
		System.out.print(this.ID + ", ");
		System.out.print(this.severity + ", ");
		System.out.print(this.startTime[0] + "-" + this.startTime[1] + "-" + this.startTime[2] + " " + this.startTime[3] + ":" + this.startTime[4] + ":" + this.startTime[5] + ", ");
		System.out.print(this.endTime[0] + "-" + this.endTime[1] + "-" + this.endTime[2] + " " + this.endTime[3] + ":" + this.endTime[4] + ":" + this.endTime[5] + ", ");
		System.out.print(this.street + ", ");
		System.out.print(this.city + ", ");
		System.out.print(this.county + ", ");
		System.out.print(this.state + ", ");
		System.out.print(this.temperature + ", ");
		System.out.print(this.humidity + ", ");
		System.out.print(this.visibility + ", ");
		System.out.print(this.weather + ", ");
		System.out.print(this.atCrossing + ", ");
		System.out.println(this.isDay);
	}
	
	public Report(String ID, int Severity, int[] StartTime, int[] EndTime, String Street,
			String City, String County, String State, double Temperature, double Humidity, double Visibility,
			String Weather, boolean AtCrossing, boolean IsDay) {
		this.ID = ID;
		this.severity = Severity;
		this.startTime = StartTime;
		this.endTime = EndTime;
		this.street = Street;
		this.city = City;
		this.county = County;
		this.state = State;
		this.temperature = Temperature;
		this.humidity = Humidity;
		this.visibility = Visibility;
		this.weather = Weather;
		this.atCrossing = AtCrossing;
		this.isDay = IsDay;
		
		
	}
	
	/**complexity of n. For every report, the while loop runs once, plus one extra time.
	 *the scanner created in the main method is passed as a parameter, where a while loop
	 *adds to reportCount until there are no more lines. reportCount starts at -1 to account for the first line.
	 *When there are no more lines, and every entry has been read, the integer reportCount is returned.
	 *This method is used to find the size of the array of reports.
	 *COPIED FROM EXECUTION.JAVA
	 */
	public static int findReportCount(Scanner scn){//passes the scanner as a parameter to get the number of reports
		long startTime = System.nanoTime();
		int reportCount = -1;//starts at -1 to account for first line
		
		while(scn.hasNextLine()) {
			scn.nextLine();
			reportCount += 1;
		}
		
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime) + " nanoseconds to run findReportCount");
		return reportCount;
	} 
	
	/**complexity of 1. Everything runs once, no for-loops or while-loops
	 * This method takes the scanner, based on the .csv of accidents, as a parameter. It scans through
	 * every section of each line in the .csv, and creates a report object from the weather condition, startTime,
	 * state, severity, etc, of the report as it exists as a line of text in the file. It returns this
	 * report object. COPIED FROM EXECUTION.JAVA
	 */
	public static Report createReport(Scanner scn) {//a method for creating a report
		scn.useDelimiter(",|\\n");
		String ID = scn.next();
		int Severity = Integer.parseInt(scn.next());
		int StartTime[] = timeStringToInts(scn.next());
		int EndTime[] = timeStringToInts(scn.next());
		String Street = scn.next();
		String City = scn.next();
		String County = scn.next();
		String State = scn.next();
		double Temperature = Double.parseDouble(scn.next());
		double Humidity = Double.parseDouble(scn.next());
		double Visibility = Double.parseDouble(scn.next());
		String Weather = scn.next();
		boolean AtCrossing;
		boolean IsDay;
		if (scn.next().equals("FALSE")) {AtCrossing = false;} else {AtCrossing = true;}
		if (scn.next().substring(0,1).equals("N")) {IsDay = false;} else {IsDay = true;	}
		Report r = new Report(ID, Severity, StartTime, EndTime, Street, City, County, State, Temperature, Humidity, Visibility, Weather, AtCrossing, IsDay);
		r.date = new MyDate(StartTime[0], StartTime[1], StartTime[2]);//this constructor is supposedly deprecated but I don't really care for now
		return r;	}
	
	/**Complexity of 1. Every statement just runs once, no loops.
	 * the string timeAsString is passed as a parameter. In order for the method
	 * to work, the string must follow the format YYYY-MM-DD HH:MM:SS
	 * This method parses the strings to find the year, month, day, hour, minute, and second in the string.
	 * It then populates an array of 6 ints with these values, and this array is returned.
	 * The returned array, timeAsIntArray, is used to create the time field in a report object.
	 * COPIED FROM EXECUTION.JAVA
	*/
	public static int[] timeStringToInts(String timeAsString) {//this takes a string in the format used for the time of

		int year = Integer.parseInt(timeAsString.substring(0, 4));//the incident and turns it into an array of ints, passed by pointer
		int month = Integer.parseInt(timeAsString.substring(5, 7));//substring selects a segment of the string to be parsed.
		int day = Integer.parseInt(timeAsString.substring(8, 10));//Parse turns the segment to an int.
		int hour = Integer.parseInt(timeAsString.substring(11,13));
		int minute = Integer.parseInt(timeAsString.substring(14,16));
		int second = Integer.parseInt(timeAsString.substring(17,19));
		
		int timeAsIntArray[] = {year, month, day, hour, minute, second};
		
		return timeAsIntArray;
	}
}
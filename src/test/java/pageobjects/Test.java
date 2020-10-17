package pageobjects;

public class Test {

	public static void main(String[] args) {
//		String date = "03/06/1987";
//		int intDate,day,month,year;
//		System.out.println(date);
//		date = date.replaceAll("/","");
//		intDate = Integer.parseInt(date);
//		
//		year = intDate % 10000;
//		System.out.println(year);
//		month= intDate /10000 % 100;
//		System.out.println(month);
//		day= intDate /1000000;
//		System.out.println(day);
		String item = "falafel";
		String  expected = "No results were found for your search " + "\"" + item + "\"";;
//		String actual = "7 results have been found.";
		System.out.println(expected);
		
		String str = "              ffff          ";
		System.out.println(str.trim());

	}
	

}

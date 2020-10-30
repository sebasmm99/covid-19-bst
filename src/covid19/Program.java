package covid19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		PatientBST c19 = new PatientBST();
		
		BufferedReader bf = new BufferedReader(new FileReader("datos-covid19bst.txt"));
		
		c19.cantPatients = Integer.parseInt(bf.readLine());
		
		String[] arrDataPatient;
		for(int i=0; i<c19.cantPatients; i++) {
			arrDataPatient = bf.readLine().split(",");
			Patient patient = new Patient(arrDataPatient[0],Integer.parseInt(arrDataPatient[1]),arrDataPatient[2],arrDataPatient[3],arrDataPatient[4],arrDataPatient[5],arrDataPatient[6]);
			c19.addPatient(patient);
		}
		
		Patient searchResult = c19.search(564892);
		if(searchResult == null) {
			System.out.println("Patient not found");
		}
		else {
			System.out.println("Patient found: " + searchResult.name + ", has " + searchResult.cantSymptoms() + " symptoms" + searchResult.symptomsDescr() + "and should pay: " + searchResult.payThreatment());
		}
		
		int symptomCheck = c19.numberCases("headache");
		System.out.println("a. Currently " + symptomCheck + " patients suffer from this symptom ");
		
		String common = c19.commonSymptom();
		System.out.println("b. The most common symptom is " + common);
		
		float average = c19.paymentAverage();
		System.out.println("c. The patients payment average is " + average);
		
		Patient moreSick = c19.patientMoreSymptoms;
		System.out.println("d. The patient with the biggets number of symptoms is " + moreSick.name);

	}

}

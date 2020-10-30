package covid19;

public class Patient {
	
	public Patient(String vlrName, int vlrId, String vlrSymptom1, String vlrSymptom2, String vlrSymptom3, String vlrSymptom4, String vlrSymptom5) {
		name = vlrName;
		id = vlrId;
		symptoms[0] = vlrSymptom1;
		symptoms[1] = vlrSymptom2;
		symptoms[2] = vlrSymptom3;
		symptoms[3] = vlrSymptom4;
		symptoms[4] = vlrSymptom5;
	}
	
	String name;
	int id;
	String[] symptoms = new String[5];
	
	int cantSymptoms() {
		int index = 0;
		int count = 0;
		while(symptoms.length > index) {
			if(symptoms[index].equals("null")) {
				index++;
			}
			else {
				count++;
				index++;
			}
		}
		return count;
	}
	
	int feberCheck() {
		int index = 0;
		int count = 0;
		while(symptoms.length > index) {
			if(symptoms[index].equals("feber")) {
				count++;
				index++;
			}
			else {
				index++;
			}
		}
		return count;
	}
	
	int headacheCheck() {
		int index = 0;
		int count = 0;
		while(symptoms.length > index) {
			if(symptoms[index].equals("headache")) {
				count++;
				index++;
			}
			else {
				index++;
			}
		}
		return count;
	}
	
	int fatigueCheck() {
		int index = 0;
		int count = 0;
		while(symptoms.length > index) {
			if(symptoms[index].equals("fatigue")) {
				count++;
				index++;
			}
			else {
				index++;
			}
		}
		return count;
	}
	
	int conjunctivitisCheck() {
		int index = 0;
		int count = 0;
		while(symptoms.length > index) {
			if(symptoms[index].equals("conjunctivitis")) {
				count++;
				index++;
			}
			else {
				index++;
			}
		}
		return count;
	}
	
	int diarrheaCheck() {
		int index = 0;
		int count = 0;
		while(symptoms.length > index) {
			if(symptoms[index].equals("diarrhea")) {
				count++;
				index++;
			}
			else {
				index++;
			}
		}
		return count;
	}
	
	String symptomsDescr() {
		int index = 0;
		String Descr = ": ";
		while(symptoms.length > index) {
			if(symptoms[index].equals("null")) {
				index++;
			}
			else {
				Descr = Descr + symptoms[index] + ", ";
				index++;
			}
		}
		return Descr;
	}
	
	float payThreatment() {
		float pay = 0;
		pay = cantSymptoms() * 100;
		return pay;
	}
	
}
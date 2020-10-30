package covid19;

public class PatientBST {
	
	NodePatient root;
	
	int cantPatients;
	float totalPayment = 0;
	int feberCases = 0;
	int headacheCases = 0;
	int fatigueCases = 0;
	int conjunctivitisCases = 0;
	int diarrheaCases = 0;
	
	Patient patientMoreSymptoms = new Patient("nn",1,"null","null","null","null","null");
	
	public void addPatient(Patient newPatient) {
		if(root == null) {
			root = new NodePatient(newPatient);
			System.out.println(newPatient.name + " is added to the system");
			totalPayment = totalPayment + newPatient.payThreatment();
			feberCases = feberCases + newPatient.feberCheck();
			headacheCases = headacheCases + newPatient.headacheCheck();
			fatigueCases = fatigueCases + newPatient.fatigueCheck();
			conjunctivitisCases = conjunctivitisCases + newPatient.conjunctivitisCheck();
			diarrheaCases = diarrheaCases + newPatient.diarrheaCheck();
			if(newPatient.cantSymptoms()>patientMoreSymptoms.cantSymptoms()) {
				patientMoreSymptoms = newPatient;
			}
			return;
		}
		
		addPatient(root, newPatient);
		
	}
	
	private void addPatient(NodePatient node, Patient newPatient) {
		
		if(node == null) {
			return;
		}
		
		if(newPatient.id > node.patient.id) {
			if(node.right == null) {
				node.right = new NodePatient(newPatient);
				System.out.println(newPatient.name + " is added to the system");
				totalPayment = totalPayment + newPatient.payThreatment();
				feberCases = feberCases + newPatient.feberCheck();
				headacheCases = headacheCases + newPatient.headacheCheck();
				fatigueCases = fatigueCases + newPatient.fatigueCheck();
				conjunctivitisCases = conjunctivitisCases + newPatient.conjunctivitisCheck();
				diarrheaCases = diarrheaCases + newPatient.diarrheaCheck();
				if(newPatient.cantSymptoms()>patientMoreSymptoms.cantSymptoms()) {
					patientMoreSymptoms = newPatient;
				}
			}
			else {
				addPatient(node.right, newPatient);
			}
		}
		else if(newPatient.id < node.patient.id) {
			if(node.left == null) {
				node.left = new NodePatient(newPatient);
				System.out.println(newPatient.name + " is added to the system");
				totalPayment = totalPayment + newPatient.payThreatment();
				feberCases = feberCases + newPatient.feberCheck();
				headacheCases = headacheCases + newPatient.headacheCheck();
				fatigueCases = fatigueCases + newPatient.fatigueCheck();
				conjunctivitisCases = conjunctivitisCases + newPatient.conjunctivitisCheck();
				diarrheaCases = diarrheaCases + newPatient.diarrheaCheck();
				if(newPatient.cantSymptoms()>patientMoreSymptoms.cantSymptoms()) {
					patientMoreSymptoms = newPatient;
				}
			}
			else {
				addPatient(node.left, newPatient);
			}
		} 
		else {
			System.out.println(newPatient.name + " is duplicated, so couldn't be added to the system again.");
		}
	} 
	
	public Patient search(int id) {
		return search(root, id);
	}
	
	private Patient search(NodePatient node, int id) {
		if(node == null) {
			return null;
		}
		if(node.patient.id == id) {
			return node.patient;
		}
		
		if(node.patient.id < id) {
			return search(node.right, id);
		}
		
		return search(node.left, id);
	}
	
	
	public float paymentAverage() {
		float average = 0; 
		average = totalPayment / cantPatients;
		return average;
	}
	
	public String commonSymptom() {
		String common = null;
		if((feberCases>headacheCases)&&(feberCases>fatigueCases)&&(feberCases>conjunctivitisCases)&&(feberCases>diarrheaCases)) {
			common = "feber";
		}
		else if((headacheCases>feberCases)&&(headacheCases>fatigueCases)&&(headacheCases>conjunctivitisCases)&&(headacheCases>diarrheaCases)) {
			common = "headache";
		}
		else if((fatigueCases>feberCases)&&(fatigueCases>headacheCases)&&(fatigueCases>conjunctivitisCases)&&(fatigueCases>diarrheaCases)) {
			common = "fatigue";
		}
		else if((conjunctivitisCases>feberCases)&&(conjunctivitisCases>headacheCases)&&(conjunctivitisCases>fatigueCases)&&(conjunctivitisCases>diarrheaCases)) {
			common = "conjunctivitis";
		}
		else if((diarrheaCases>feberCases)&&(diarrheaCases>headacheCases)&&(diarrheaCases>fatigueCases)&&(diarrheaCases>conjunctivitisCases)) {
			common = "diarrhea";
		}
		return common;
	}
	
	public int numberCases(String symp) {
		int cant = 0;
		if(symp.equals("feber")) {
			cant = feberCases;
		}
		else if(symp.equals("headache")) {
			cant = headacheCases;
		}
		else if(symp.equals("fatigue")) {
			cant = fatigueCases;
		}
		else if(symp.equals("conjunctivitis")) {
			cant = conjunctivitisCases;
		}
		else if(symp.equals("diarrhea")) {
			cant = diarrheaCases;
		}
		else {
			cant = 0;
		}
		
		return cant;
	}

}

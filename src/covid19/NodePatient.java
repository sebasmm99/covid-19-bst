package covid19;

public class NodePatient {
	
	public NodePatient(Patient newPatient) {
		this.patient = newPatient;
	}
	
	Patient patient;
	NodePatient left;
	NodePatient right;

}

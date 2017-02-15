public class Candidate {

private String candidateName;
private int totalVotes;


public Candidate(String name, int votes) {
	totalVotes = votes;
	candidateName = name;
	
}


public String getCandidateName() {
	return candidateName;
}

public int getTotalVotes() {
	return totalVotes;
}


}
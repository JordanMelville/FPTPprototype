
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class FPTPImplementation {
	
private ArrayList<Candidate> candidateList = new ArrayList<Candidate>();


public void addaCandidate(Candidate candidate) {
	candidateList.add(candidate);
}

public static void main(String[] args) throws IOException{
	// set up an instance of fptp and call the relevant methods to read from file
	// then calculate the winner of the seat.
	FPTPImplementation fptp = new FPTPImplementation();
	fptp.LoadVotingData("testingData.txt");
	fptp.calculateWinnerVotes();
	
	}


private int getTotalNumberVotes() {
	int voteCounter = 0;
	for(Candidate nextCandidate: candidateList) {
		voteCounter = voteCounter + nextCandidate.getTotalVotes();
	}
	
	return voteCounter;
	
}

private double getVotePercentage() {
	return calculateWinnerVotes() / getTotalNumberVotes();
}


private int calculateWinnerVotes() {
	    System.out.println("The votes have been counted and the results are as follows");
		Candidate candidate = candidateList.get(0);
		System.out.println(candidate.getCandidateName() + "Votes: " + candidate.getTotalVotes());
		for(Candidate nextCandidate: candidateList) {
			System.out.println(nextCandidate.getCandidateName() + "Votes: " + nextCandidate.getTotalVotes());
		}
		
		for(Candidate adjacentCandidate: candidateList) {
			// iterate through to find the candidate the most amount of votes.
			if(adjacentCandidate.getTotalVotes() > candidate.getTotalVotes()) {
				candidate = adjacentCandidate;
			}
			// the value held in candidate now will contain the candidate with the highest votes
			System.out.println("Therefore, with " + getVotePercentage()  + "% of the votes, candidate " + candidate.getCandidateName() + " has been elected as the MP for East Kilbride.");
			}
		return candidate.getTotalVotes();
		}
		
		
	



// load in data and create party data to be then used for calculating seats
public void LoadVotingData(String file) {
	Scanner sc;
	try{
		sc = new Scanner(new File(file));
		
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			Scanner scanLine = new Scanner(line);
			String candidateName = scanLine.next();
			int votes = scanLine.nextInt();
			Candidate newCandidate = new Candidate(candidateName, votes);
			this.addaCandidate(newCandidate);
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
	} 
	}


 
}

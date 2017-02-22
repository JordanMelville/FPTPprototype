
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







private void calculateWinnerVotes() {
	    
		Candidate candidate = candidateList.get(0);
		for(Candidate nextCandidate: candidateList) {
			System.out.println(nextCandidate.getCandidateName() + "'s Votes: " + nextCandidate.getTotalVotes());
		}
		
		for(Candidate adjacentCandidate: candidateList) {
			// iterate through to find the candidate the most amount of votes.
			if(adjacentCandidate.getTotalVotes() > candidate.getTotalVotes()) {
				candidate = adjacentCandidate;
			}
			
			
		}
		System.out.println();
		System.out.println("The winner with the most votes is " + candidate.getCandidateName() + ".");
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

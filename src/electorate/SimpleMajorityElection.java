package electorate;

import java.util.ArrayList;

import voting.SimpleMajorityVote;
import voting.Vote;

public class SimpleMajorityElection extends Election{
	ArrayList<SimpleMajorityVote> votes;
	
	public SimpleMajorityElection(ArrayList<String> candidates){
		super(candidates);
		this.votes = new ArrayList<SimpleMajorityVote>();
	}
	
	public void enterBallot(SimpleMajorityVote v){
		this.votes.add(v);
	}
	
	/**
	 * Return the candidate with a simple majority (ie. more than 
	 * 50% of the votes), or null if no such candidate exists. 
	 * 
	 * Uses a the Boyer-Moore Counting Algorithm, which is pretty
	 * slick. Runs in O(n) time and uses O(1) space :o
	 * 
	 * @return String representing candidate with a simple majority,
	 * or null if no such candidate exists.
	 */
	public String findMajority(){
		String candidate = null;
		int count = 0;
		for (SimpleMajorityVote s: this.votes){
			if (candidate == null){
				candidate = s.getVote();
				count++;
			}
			else{
				if (candidate.equals(s.getVote())){
					count++;
				}
				else{
					count--;
				}
			}
			
			if (count <= 0){
				candidate = s.getVote();
				count = 1;
			}
		}
		return candidate;
	}
	
	public static void main(String[] args){
		ArrayList<String> cans = new ArrayList<String>();
		cans.add("Amy");
		cans.add("Billy");
		cans.add("Cameron");
		SimpleMajorityElection El = new SimpleMajorityElection(cans);
		Voter v1 = new Voter();
		for (int i = 0; i < 8; i++){
			El.enterBallot(new SimpleMajorityVote(v1, "Amy"));
		}
		El.enterBallot(new SimpleMajorityVote(v1, "Billy"));
		El.enterBallot(new SimpleMajorityVote(v1, "Cameroon"));
		System.out.println(El.findMajority());
	}
}

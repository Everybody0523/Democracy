package electorate;

import java.util.ArrayList;

public class Voter {
	private int membershipNumber;
	public int getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(int membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	private ArrayList<String> rankings;

	public ArrayList<String> getRankings() {
		return rankings;
	}

	public void setRankings(ArrayList<String> rankings) {
		this.rankings = rankings;
	}
	
	

	@Override
	/**
	 * 
	 * @param that The voter that we are performing the comparison to.
	 * 
	 * Returns true if and only if two Voters have the same membershipNumber.
	 * 
	 */
	public boolean equals(Object that){
		// Return true of they are the same thing.
		if (this == that){
			return true;
		}
		
		// Make sure that is a Voter.
		else if (!(that instanceof Voter)){
			return false;
		}
		
		
		else{
			// Typecast that so we can compare membership numbers
			Voter that1 = (Voter) that;
			// Return whether or not they are equal.
			return (that1.getMembershipNumber() == this.getMembershipNumber());
		}
	}
	
	/**
	 * 
	 * @param elec The election that this voter is participating in.
	 * 
	 * Removes eliminated or illegitimate candidates from the list of candidates. 
	 * 
	 */
	public void cleanVotes(Election elec){
		// Loop over all the candidates this voter has and checks to see if they are
		// still in the election's list of candidates.
		for(String candidate : this.rankings){
			ArrayList<String> remainingCandidates = elec.getCandidates();
			if (!(remainingCandidates.contains(candidate))){
				this.rankings.remove(candidate);
			}
		}
	}
	
	/**
	 * 
	 * @param loser The candidate being eliminated. What a loser lol.
	 * 
	 * Remove a candidate from the voter's rankings.
	 * 
	 */
	public void eliminateCandidate(String loser){
		this.rankings.remove(loser);
	}
	
	
	
	
}
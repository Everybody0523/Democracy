package voting;

import electorate.Voter;

public class SimpleMajorityVote extends Vote{
	private String vote;

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public SimpleMajorityVote(Voter voteCaster, String vote){
		super(voteCaster);
		this.vote = vote;
	}
	
	public boolean sameVote(SimpleMajorityVote otherVote){
		return (this.vote.equals(otherVote.getVote()));
	}
}

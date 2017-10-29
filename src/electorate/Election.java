package electorate;

import java.util.ArrayList;
import voting.Vote;

public abstract class Election {
	protected ArrayList<String> candidates;
	
	public ArrayList<String> getCandidates() {
		return candidates;
	}
	public void setCandidates(ArrayList<String> candidates) {
		this.candidates = candidates;
	}
	
	protected Election(ArrayList<String> candidates){
		this.candidates = candidates;
	}
	
	protected boolean AddVote(Vote v){
		
		return true;
	}
}
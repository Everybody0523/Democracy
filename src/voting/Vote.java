package voting;
import electorate.Voter;

public abstract class Vote {
	private Voter voteCaster;

	public Voter getVoteCaster() {
		return voteCaster;
	}

	public void setVoteCaster(Voter voteCaster) {
		this.voteCaster = voteCaster;
	}
	
	protected Vote(Voter voteCaster){
		this.voteCaster = voteCaster;
	}
}

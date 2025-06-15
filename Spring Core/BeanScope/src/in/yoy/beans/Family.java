package in.yoy.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("pariwar")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Family {
	
	@Value("4")
	private int members ;
	@Value("Father")
	private String head ;
	@Value("False")
	private boolean rich ;
	
	public Family() {
		super();
	}

	public Family(int members, String head, boolean rich) {
		super();
		this.members = members;
		this.head = head;
		this.rich = rich;
	}

	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public boolean isRich() {
		return rich;
	}
	public void setRich(boolean rich) {
		this.rich = rich;
	}

	
}

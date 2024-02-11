package Event;

import java.time.ZonedDateTime;

import EventUpdate.AbstractAuditableEvent;

public class NoDisturbance extends AbstractEvent{

	public NoDisturbance(int id, String title,
			ZonedDateTime startAt, ZonedDateTime endAt) {
		super(id, title, startAt, endAt);
	}

	@Override
	public void print() {
		System.out.printf("[방해금지] %s%n", getTitle());
	}
	
	@Override
	public boolean support(EventType type) {
		return type == EventType.NO_DISTURBANCE;
	}

	@Override
	protected void update(AbstractAuditableEvent update) {
		
	}

}

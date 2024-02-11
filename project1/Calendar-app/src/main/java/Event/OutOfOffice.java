package Event;

import java.time.ZonedDateTime;

import EventUpdate.AbstractAuditableEvent;

public class OutOfOffice extends AbstractEvent {

	public OutOfOffice(int id, String title,
			ZonedDateTime startAt, ZonedDateTime endAt) {
		super(id, title, startAt, endAt);
	}

	@Override
	public void print() {
		System.out.printf("[출장] %s%n", getTitle());
	}

	@Override
	public boolean support(EventType type) {
		return type == EventType.OUT_OT_OFFICE;
	}

	@Override
	protected void update(AbstractAuditableEvent update) {
		
	}
}

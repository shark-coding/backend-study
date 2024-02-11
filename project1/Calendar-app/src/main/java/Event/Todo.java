package Event;

import java.time.ZonedDateTime;

import EventUpdate.AbstractAuditableEvent;

public class Todo extends AbstractEvent{

	private String description;
	
	public Todo(int id, String title,
			ZonedDateTime startAt, ZonedDateTime endAt,
			String description) {
		super(id, title, startAt, endAt);
		this.description = description;
	}

	@Override
	public void print() {
		System.out.printf("[할일] %s : %s%n", getTitle(), description);
	}
	
	@Override
	public boolean support(EventType type) {
		return type == EventType.TO_DO;
	}

	@Override
	protected void update(AbstractAuditableEvent update) {
		
	}
	
}

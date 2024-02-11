package Event;

import java.time.Duration;
import java.time.ZonedDateTime;

import EventUpdate.AbstractAuditableEvent;
import Exception.InvalidEventException;

public abstract class AbstractEvent implements Event {

	private final int id;
	private String title;
	
	private ZonedDateTime startAt;
	private ZonedDateTime endAt;
	private Duration duration;
	
	private final ZonedDateTime createdAt;
	private ZonedDateTime modifiedAt;
	
	private boolean deletedYn;
	
	// 등록
	protected AbstractEvent(int id, String title,
			ZonedDateTime startAt, ZonedDateTime endAt) {
		
		if(startAt.isAfter(endAt)) {
			throw new InvalidEventException(
					String.format("시작일은 종료일보다 이전이어야 합니다. 시작일=%s, 종료일=%s", startAt, endAt)
					);
		}
		
		this.id = id;
		this.title = title;
		this.startAt = startAt;
		this.endAt = endAt;
		this.duration = Duration.between(startAt, endAt);
		
		ZonedDateTime now = ZonedDateTime.now();
		this.createdAt = now;
		this.modifiedAt = now;
		
		this.deletedYn = false;
	}
	
	// 수정
	public void validateAndUpdate(AbstractAuditableEvent update) {
		if(deletedYn == true) {
			throw new RuntimeException("이미 삭제된 이벤트는 수정 불가");
		}
		
		defaultUpdate(update);
		update(update);
	}
	
	private void defaultUpdate(AbstractAuditableEvent update) {
		this.title = update.getTitle();
		this.startAt = update.getStartAt();
		this.endAt = update.getEndAt();
		this.duration = Duration.between(this.startAt, this.endAt);
		this.modifiedAt = ZonedDateTime.now();
	}
	protected abstract void update(AbstractAuditableEvent update);
	
	// 삭제
	public void delete(boolean deletedYn) {
		this.deletedYn = deletedYn;
	}
	
	// getter
	public String getTitle() {
		return this.title;
	}
	
	public ZonedDateTime getStartAt() {
		return startAt;
	}
	
	public ZonedDateTime getEndAt() {
		return endAt;
	}
}

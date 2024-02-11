package Event;

public interface Event {
	void print();
	
	boolean support(EventType type);
}

package CalendarApp;


import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import Event.Meeting;
import Event.NoDisturbance;
import Event.OutOfOffice;
import Event.Schedule;
import Event.Todo;
import EventUpdate.UpdateMeeting;
import Reader.EventCsvReader;
import Reader.RawCsvReader;

public class CalendarAppAppliction {

	public static void main(String[] args) throws IOException, CsvException {
		Schedule schedule = new Schedule();

		EventCsvReader csvReader = new EventCsvReader(new RawCsvReader());
		String meetingCsvPath = "/Data/meeting.csv";
		String noDisturbanceCsvPath = "/Data/no_disturbance.csv";
		String outOfOfficCsvPath = "/Data/out_of_office.csv";
		String toDoCsvPath = "/Data/to_do.csv";
		
		List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
		meetings.forEach(schedule::add);
		
		List<NoDisturbance> noDisturbance = csvReader.readNoDisturbance(noDisturbanceCsvPath);
		noDisturbance.forEach(schedule::add);
		
		List<OutOfOffice> outOfOffice = csvReader.readOutOfOffice(outOfOfficCsvPath);
		outOfOffice.forEach(schedule::add);
		
		List<Todo> todo = csvReader.readTodo(toDoCsvPath);
		todo.forEach(schedule::add);
		
		
		schedule.printAll();

//		Meeting meeting = meetings.get(0);
//		meeting.print();
//		System.out.println("수정 후..");
//		
//		meeting.validateAndUpdate(
//				new UpdateMeeting(
//						"new title",
//						ZonedDateTime.now(),
//						ZonedDateTime.now().plusHours(1),
//						null,
//						"A",
//						"new agenda")
//				);
//		meeting.print();
//		
//		meeting.delete(true);
//		System.out.println("삭제 후 수정 시도..");
//		
//		meeting.validateAndUpdate(
//				new UpdateMeeting(
//						"new title2",
//						ZonedDateTime.now(),
//						ZonedDateTime.now().plusHours(1),
//						null,
//						"B",
//						"new agenda2")
//				);
//		meeting.print();
//		
//		//		schedule.printBy(EventType.TO_DO);
////		schedule.printAll();
	}
}

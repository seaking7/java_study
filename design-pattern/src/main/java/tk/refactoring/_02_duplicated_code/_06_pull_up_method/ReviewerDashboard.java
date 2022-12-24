package tk.refactoring._02_duplicated_code._06_pull_up_method;

import java.io.IOException;

public class ReviewerDashboard extends Dashboard {


    public void printParticipants(int eventId) throws IOException {
        // Get github issue to check homework
        super.printParticipants(eventId);
    }

}

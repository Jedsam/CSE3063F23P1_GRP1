import java.util.ArrayList;
import java.util.List;

class Assistant extends Staff {
    private String assistantID;

    // Constructors
    public Assistant() {

    }

    public Assistant(String name, String lastName, String assistantID) {
        super(name, lastName);
        this.assistantID = assistantID;
    }

    public String getAssistantID() {
        return assistantID;
    }

    @Override
    public String toString() {
        return "Assistant: " + this.getFirstName() + " " + this.getLastName();
    }

}
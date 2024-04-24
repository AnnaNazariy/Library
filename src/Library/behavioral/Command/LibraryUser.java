package Library.behavioral.Command;

public class LibraryUser {
    private Command borrowCommand;
    private Command returnCommand;

    public LibraryUser(Command borrowCommand, Command returnCommand) {
        this.borrowCommand = borrowCommand;
        this.returnCommand = returnCommand;
    }

    public void borrowBook() {
        borrowCommand.execute();
    }

    public void returnBook() {
        returnCommand.execute();
    }
}

package Library.structural.adapter;
public class AudioToTextAdapter extends AudioBook implements AudioBookAccessor {
    private final AudioBook audioBook;

    public AudioToTextAdapter(AudioBook audioBook) {
        super("");
        this.audioBook = audioBook;
    }

    @Override
    public String getContent() {
        String audioContent = audioBook.getContent();
        return convertContent(audioContent);
    }

    private String convertContent(String audioContent) {
        // Тут відбувається конвертація аудіо в текст
        return "Audio converted to text!";
    }
}

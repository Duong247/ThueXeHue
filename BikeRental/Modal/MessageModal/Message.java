package MessageModal;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Message {
	private int messID;
	private String from;
    private String to;
    private String content;
    private Date timestamp;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String from, String to, String content) {
		super();
		this.from = from;
		this.to = to;
		this.content = content;
		this.timestamp = timestamp;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
    
	// Key là tên người dùng, Value là danh sách tin nhắn gửi đến họ
	private static Map<String, List<Message>> userMessages = new ConcurrentHashMap<>();
}

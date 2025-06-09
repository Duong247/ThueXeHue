package MessageModal;

import java.util.ArrayList;

import UserModal.User;

public class MessageBO {
	MessageDAO mDAO = new MessageDAO();
	public ArrayList<Message> GetMessage(String sender, String receiver) throws Exception{
		return mDAO.GetMessage(sender, receiver);
	}
	
	public boolean insertMessage(String sender, String reciever,String content) throws Exception {
		return mDAO.insertMessage(sender, reciever, content);
	}
	public ArrayList<User> getChatUsers(String myPhone) throws Exception {
		return mDAO.getChatUsers(myPhone);
	}
}

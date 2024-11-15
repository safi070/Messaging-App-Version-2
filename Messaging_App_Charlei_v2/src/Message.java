import java.time.LocalDateTime;

public class Message {
    String senderName ;
    String receiverName;
    String messageContent;
    LocalDateTime timeStamp;
    boolean isSeen;
    String messageId;

    static int counter=0;

    public Message(String senderName, String receiverName, String messageContent) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.messageContent = messageContent;
        timeStamp=LocalDateTime.now();
        this.isSeen = false; // message is not seen.
        this.messageId= String.format(" %03d ",++counter);
        // this.messageId=messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }
    public String getSenderName(){
        return senderName;
    }

    public void setSeen(boolean status) {
        this.isSeen = status;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public boolean isSeen() {
        return isSeen;
    }

    @Override
    public String toString() {
        return
                "senderName='" + senderName + '\'' +
                        ", receiverName='" + receiverName + '\'' +
                        ", messageContent='" + messageContent + '\'' +
                        ", timeStamp=" + timeStamp +
                        ", status=" + isSeen +
                        ", messageId='" + messageId + '\'';
    }
}

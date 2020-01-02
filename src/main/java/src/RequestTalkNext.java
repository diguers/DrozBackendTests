package src;

public class RequestTalkNext {
    private String sessionId;
    private Integer talkId;
    private Integer questionId;
    private String answer;

    public RequestTalkNext() {
    }

    public RequestTalkNext(String sessionId, Integer talkId, Integer questionId, String answer) {
        this.sessionId = sessionId;
        this.talkId = talkId;
        this.questionId = questionId;
        this.answer = answer;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

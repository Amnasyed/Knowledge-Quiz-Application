# Quiz app

Class `Question`

```java
public class Question {

    private String question;
    private List<String> answers = new ArrayList<>();
    private String rightAnswer;

    public Question(String question,String rightAnswer, String ... answers ) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answers.add(answers[0]);
        this.answers.add(answers[1]);
        this.answers.add(answers[2]);
        this.answers.add(answers[3]);
    }


    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }
}
```




</h4>
# Output
<div style="width:100px;max-width:100%;"><div style="height:0;padding-bottom:200%;position:relative;"><iframe width="100" height="200" style="position:absolute;top:0;left:0;width:100%;height:100%;" frameBorder="0" src="https://imgflip.com/embed/60ae07"></iframe></div><p><a href="https://imgflip.com/gif/60ae07">via Imgflip</a></p></div>

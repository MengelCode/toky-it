package eu.xylandia.toky_it.controller;

import eu.xylandia.toky_it.model.Answer;
import eu.xylandia.toky_it.model.Person;
import eu.xylandia.toky_it.model.Question;
import eu.xylandia.toky_it.repositories.PersonRepository;
import eu.xylandia.toky_it.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MainRestController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/getInput")
    public String getInput(@RequestParam Optional<String> userInput) {

        String msg = "User input : ";

        if (userInput.isPresent()) {
            msg += userInput.get();

            // TODO : Handle question's author
            questionRepository.save(new Question(new Person("JohnDoe"), userInput.get()));
        }


        return msg;
    }

    @PostMapping("/setAnswer")
    public void setAnswer(@RequestParam long selectedQuestionId, @RequestParam String givenAnswer) {

        Question question = questionRepository.findById(selectedQuestionId);
        question.getAnswer().add(new Answer(new Person("John Doe"), givenAnswer));
        questionRepository.save(question);
    }

    @GetMapping("/getQuestions")
    public Iterable<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @PostMapping("/getQuestion")
    public Question getQuestion(@RequestParam long idQuestion) {
        return questionRepository.findById(idQuestion);
    }

}

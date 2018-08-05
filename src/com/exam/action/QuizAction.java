package com.exam.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.exam.dao.QuizDAO;
import com.exam.dto.QuizDTO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuizAction extends ActionSupport implements ModelDriven<QuizDTO> {
	QuizDAO quizDAO = new QuizDAO();
	QuizDTO quizDTO = new QuizDTO();
	ArrayList list = new ArrayList<>();
	ArrayList<QuizDTO> singleQuestion = new ArrayList();
	String previousSelectionOption = null;
	static ListIterator randomQuestionWithOptionsIterator;
	static Map<String, String> selectedAnswerWithQuestion = new HashMap<String, String>();
	public static int numberOfQuestions, i = 0;
	String nextButtonVisibility = "visible";
	String previousButtonVisibility = "hidden";
	int totalMarks=0;
	String result = null;

	public String execute() {
		list = quizDAO.retrieveQuestions();
		randomQuestionWithOptionsIterator = list.listIterator();

		numberOfQuestions = list.size();
		System.out.println("Number of Questions " + list.size());

		while (randomQuestionWithOptionsIterator.hasNext()) {
			singleQuestion.add((QuizDTO) randomQuestionWithOptionsIterator.next());
			break;
		}
		return "success";
	}

	public String getNextQuestion() {
		System.out.println("Inside getNextQuestion");
		saveAnswer();
		while (randomQuestionWithOptionsIterator.hasNext()) {
			QuizDTO q = (QuizDTO) randomQuestionWithOptionsIterator.next();
			
			i = randomQuestionWithOptionsIterator.nextIndex();
			System.out.println("numberOfQuestions " + numberOfQuestions + "and i =" + i);
			if (i == numberOfQuestions) {

				nextButtonVisibility = "hidden";
				previousButtonVisibility = "visible";

				System.out.println(nextButtonVisibility + " " + previousButtonVisibility);
			} else {
				nextButtonVisibility = "visible";
				previousButtonVisibility = "visible";
				System.out.println(nextButtonVisibility + " " + previousButtonVisibility);
			}
			previousSelectionOption = selectedAnswerWithQuestion.get(q.getHquestion());
			singleQuestion.add(q);
			break;
		}
		return "success";
	}

	public void saveAnswer() {
		selectedAnswerWithQuestion.put(quizDTO.getHquestion(), quizDTO.getAnswer1());
		String ques = quizDTO.getHquestion();
		String ans = quizDTO.getAnswer1();
		System.out.println(ques + " and " + ans);
	}

	public String getPreviousQuestion() {
		System.out.println("Inside getpreviousQuestion");
		saveAnswer();
		while (randomQuestionWithOptionsIterator.hasPrevious()) {
			QuizDTO q = (QuizDTO) randomQuestionWithOptionsIterator.previous();
			int previousIndex = randomQuestionWithOptionsIterator.previousIndex();
			System.out.println("numberOfQuestions " + numberOfQuestions + "and previousIndex =" + previousIndex);
			if (previousIndex == -1) {
				previousButtonVisibility = "hidden";
				System.out.println(previousButtonVisibility);
			} else {
				nextButtonVisibility = "visible";
				previousButtonVisibility = "visible";
				System.out.println(previousButtonVisibility);
			}
			previousSelectionOption = selectedAnswerWithQuestion.get(q.getHquestion());
			singleQuestion.add(q);
			break;
		}
		return "success";
	}

	public String getMarks() {
		saveAnswer();
		Set s = selectedAnswerWithQuestion.entrySet();
		Iterator iterateQustionAndSelectedOption = s.iterator();
		while(iterateQustionAndSelectedOption.hasNext()) {
			Map.Entry<String, String> m = (Map.Entry<String, String>)iterateQustionAndSelectedOption.next();
			System.out.println("Key : "+m.getKey()+" value: "+m.getValue());
			if(quizDAO.checkAnswers(m.getKey(), m.getValue())) {
				totalMarks++;		
			}
			
		}
		if(totalMarks>=(0.7*numberOfQuestions)) {
			System.out.println("Congratulations you passed the test");
			//result= LoginAction.actorName + ", Congratulations you passed the test!!";
			result = "Congratulations you passed the test"+","+"total marks :  "+totalMarks;
		}
		else {
			System.out.println("Sorry, you Failed");
			//result = LoginAction.actorName + ", Sorry, you Failed.";
			result = "Sorry, you Failed." +" ,"+"total marks :  "+totalMarks;
		}
		System.out.println("total marks :  " +totalMarks);
/*		if(quizDAO.saveMarks(totalMarks, LoginAction.actorName)) {	//to add marks secured in database
		return "success";
		}
		else
			return "input";*/
		return "success";
	}

	public String saveExam() {
		quizDTO = new QuizDTO();
		System.out.println(quizDTO.getQuestion() + " " + quizDTO.getAnswer2());
		return "success";
	}

	public ArrayList<QuizDTO> getSingleQuestion() {
		return singleQuestion;
	}

	public void setSingleQuestion(ArrayList<QuizDTO> singleQuestion) {
		this.singleQuestion = singleQuestion;
	}

	public String getNextButtonVisibility() {
		return nextButtonVisibility;
	}

	public void setNextButtonVisibility(String nextButtonVisibility) {
		this.nextButtonVisibility = nextButtonVisibility;
	}

	public String getPreviousButtonVisibility() {
		return previousButtonVisibility;
	}

	public void setPreviousButtonVisibility(String previousButtonVisibility) {
		this.previousButtonVisibility = previousButtonVisibility;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPreviousSelectionOption() {
		return previousSelectionOption;
	}

	public void setPreviousSelectionOption(String previousSelectionOption) {
		this.previousSelectionOption = previousSelectionOption;
	}

	@Override
	public QuizDTO getModel() {
		// TODO Auto-generated method stub
		return quizDTO;
	}
}

package com.vti.frontend;

import java.time.LocalDate;
import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Question;
import com.vti.entity.TypeQuestion;

public class Demo1 {

	public static void main(String[] args) {
		System.out.println("HELLO WORLD");
		
		Department dep1 = new Department();//ham khoi tao cho doi tuong
		dep1.id = 1;
		dep1.name ="Marketing";
		
		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Sale";
		
		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "Account";
		
		//Tao Possition
		Position pos = new Position();
		pos.id = 1;
		pos.name = PositionName.SCRUM_MASTER;
		
		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.DEV;
		
		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.PM;
		
		Position pos4 = new Position();
		pos4.id = 4;
		pos4.name = PositionName.TEST;
		
		//Tao group
		Group group1 = new Group();
		group1.id = 1;
		group1.name ="TestingSystem";
		
		Group group2 = new Group();
		group2.id = 2;
		group2.name="Manager";
		
		//Tao Account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email="mai";
		acc1.userName ="mai";
		acc1.fullName ="nguyen mai";
		acc1.department = dep1;
		acc1.position = pos2;
		Group[] groupAcc1 = {group1, group2};
		acc1.groups = groupAcc1;
		acc1.createDate = LocalDate.of(2021, 02, 04);
		
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email= "hung";
		acc2.userName = "hung";
		acc2.fullName="tran hung";
		acc2.department= dep2;
		acc2.position = pos3;
		Group[] groupAcc2 = {group1};
		acc2.groups = groupAcc2;
		acc2.createDate = LocalDate.now();
		
		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email ="linh";
		acc3.userName="mai";
		acc3.fullName="linh mai";
		acc3.department = dep3;
		acc3.position =pos;
		Group[] groupAcc3= {group1,group2};
		acc3.groups = groupAcc3;
		acc3.createDate = LocalDate.of(2021, 05, 05);
		
		System.out.println("In thong tin account tren he thong");
		System.out.println("Thong tin Account1: ");
		System.out.println("ID: "+acc1.id);
		System.out.println("Email: "+acc1.email);
		System.out.println("Department: "+acc1.department.name);
		System.out.println("Group: "+acc1.groups[0].name+" "+acc1.groups[1].name);
		System.out.println("Create: "+acc1.createDate);
		
		// Table 6: TypeQuestion
		//TypeID: định danh của loại câu hỏi (auto increment) TypeName: tên của loại câu hỏi (Essay, Multiple-Choice)
		TypeQuestion typeQ1 = new TypeQuestion();
		typeQ1.id = 1;
		typeQ1.name = "Essay";
		
		TypeQuestion typeQ2 = new TypeQuestion();
		typeQ2.id = 2;
		typeQ2.name = "Multiple-Choic";
		
		System.out.println("In ra thong tin typequestion tren he thong");
		System.out.println("Thong tin typequestion1");
		System.out.println("ID: "+typeQ1.id);
		System.out.println("TypeName: "+typeQ1.name);
		
		
		System.out.println("Thong tin typequestion2");
		System.out.println("ID: "+typeQ2.id);
		System.out.println("TypeName: "+typeQ2.name);
		
		//Table 7: CategoryQuestion
		 //CategoryID: định danh của chủ đề câu hỏi (auto increment)
		//CategoryName: tên của chủ đề câu hỏi (Java, .NET, SQL, Postman, Ruby, ..)
		
		CategoryQuestion caQ1 = new CategoryQuestion();
		caQ1.id = 1;
		caQ1.name = "Java";
		
		CategoryQuestion caQ2 = new CategoryQuestion();
		caQ2.id = 2;
		caQ2.name = ".NET";
		
		System.out.println("In ra thong tin categoryquestion tren he thong");
		System.out.println("Thong tin categoryquestion1");
		System.out.println("Id: "+caQ1.id);
		System.out.println("Name: "+caQ1.name);
		
		System.out.println("Thong tin categoryquestion2");
		System.out.println("Id: "+caQ2.id);
		System.out.println("Name: "+caQ2.name);
		
		
		//8:Question: QuestionID, Content, CategoryI, TypeID, CreatorID, CreateDate
		
		Question ques1 = new Question();
		ques1.id = 1;
		ques1.content = "What is SQL?";
		ques1.creatorID = 1;
		ques1.typeQ = typeQ1;
		ques1.creatorID = 1;
		ques1.createDate= LocalDate.of(2021, 03, 03);

		Question ques2 = new Question();
		ques2.id = 2;
		ques2.content = "What is Trigger?";
		ques2.creatorID = 2;
		ques2.typeQ = typeQ2;
		ques2.creatorID = 2;
		ques2.createDate = LocalDate.now();
		
		System.out.println("In ra thong tin question tren he thong");
		System.out.println("Thong tin question1");
		System.out.println("ID: "+ques1.id);
		System.out.println("Content: "+ques1.content);
		System.out.println("CreatorID: "+ques1.creatorID);
		System.out.println("Typequestion: "+ques1.typeQ);
		System.out.println("CreatorID: "+ques1.creatorID);
		System.out.println("CreateDate: "+ques1.createDate);
		
		//Q9:Answer: AnswerID, Content, QuestionID, isCorrect
		
		Answer ans1 = new Answer();
		ans1.id = 1;
		ans1.content = "SQL la ngon ngu truy van co cau truc";
		ans1.question = ques1;
		ans1.isCorrect = true;
		
		Answer ans2 = new Answer();
		ans2.id = 2;
		ans2.content = "Trigger la 1 trinh kich hoat";
		ans2.question = ques2;
		ans2.isCorrect = true;
		
		System.out.println("In ra thong tin answer tren he thong");
		System.out.println("Thong tin answer1");
		System.out.println("ID: "+ans1.id);
		System.out.println("Conent: "+ans1.content);
		System.out.println("QuestionID: "+ans1.question);
		System.out.println("Iscorrect: "+ans1.isCorrect);
		
		//Q10:Exam: ExamID,code,title,categoryid,duration,creatorid,createdate
		Exam ex1 = new Exam();
		ex1.id = 1;
		ex1.code = "abc";
		ex1.title = "SQL";
		ex1.categoryId = caQ1;
		ex1.duration = 60;
		ex1.creatorId = 1;
		ex1.createDate = LocalDate.now();
		Question[] exques1 =  {ques1};
		ex1.questions = exques1; 
		
		Exam ex2 = new Exam();
		ex2.id = 2;
		ex2.code = "bcd";
		ex2.title="Trigger";
		ex2.categoryId =caQ2;
		ex2.duration = 90;
		ex2.creatorId = 2;
		ex2.createDate = LocalDate.of(2021, 02, 03);
		Question[] exques2 = {ques1,ques2};
		ex2.questions = exques2;
		
		System.out.println("In thong tin exam tren he thong");
		System.out.println("Thong tin question1");
		System.out.println("ID: "+ex1.id);
		System.out.println("Code: "+ex1.code);
		System.out.println("Title: "+ex1.title);
		System.out.println("CatrgoryID: "+ex1.categoryId);
		System.out.println("Duration: "+ex1.duration);
		System.out.println("CreatorID: "+ex1.createDate);
		System.out.println("CreateDate: "+ex1.createDate);
		System.out.println("QuestionExam: "+ex1.questions[0].content);
		

		
	}
}

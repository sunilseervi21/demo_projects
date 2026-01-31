class Book {
        private int bookid;
        private String title;
        private boolean issued;

        public Book(int bookid,String title){
            this.bookid=bookid;
            this.title= title;
            this.issued=false;
        }
        
        public int getBookid(){
            return bookid;
        }
        public String getTitle(){
            return title;
        }

        public boolean isIssued(){
            return issued;
        }

        public void issueBook(){
            issued = true;

        }
        public void returnBook(){
            issued = false;
        }
    }



    //interface
    interface Notifier {
        void sendNotification(String message);
    } 
    
        
    //abstract class
      abstract class LibraryMember implements Notifier {
        protected int memberId;
        protected String name;

        public LibraryMember (int memberId, String name){
            this.memberId = memberId;
            this.name = name;
        }
      
        public abstract void borrowBook(Book book);
      }

//inheritance polymorphism

class StudentMember extends LibraryMember {
public StudentMember (int memberId,String name){
    super(memberId,name);
}
//override
public void borrowBook (Book book){
    if(!book.isIssued()){
        book.issueBook();
        System.out.println(name + "issue book:" + book.getTitle());
    }
}
//override

public void sendNotification(String message){
    System.out.println("student notificaton:"+ message);
}
    
}

class TeacherMember extends LibraryMember{
    
    public TeacherMember(int memberId,String name){
        super(memberId,name);

    }
//override
public void borrowBook(Book book){
    book.issueBook();
    System.out.println(name + "issued book:" + book.getTitle());
}
 //override
 public void sendNotification(String message){
    System.out.println("teacher notification:"+ message);
 }   
}

public class BankProject{
    public static void main(String[] args){
        Book book1 = new Book(101,"java basics");

        LibraryMember student = new StudentMember(1, "sunil");
        LibraryMember teacher = new TeacherMember(2,"virat");

        student.borrowBook(book1);
        student.sendNotification("return book in seven days");

        teacher.sendNotification("no return limit");       
    }

    
}
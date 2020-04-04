public class Book {

   private String title;
   private String author;
   private String publisher;
   private String publicationDate;

   public Book(){}

   public Book(String title, String author, String publisher,
               String publicationDate) {
      this.title     = title;
      this.author    = author;
      this.publisher = publisher;
      this.publicationDate = publicationDate;
   }

   public void setTitle(String userTitle) {
      title = userTitle;
   }

   public String getTitle() {
      return title;
   }

   public void setAuthor(String userAuthor) {
      author = userAuthor;
   }

   public String getAuthor(){
      return author;
   }

   public void setPublisher(String userPublisher) {
      publisher = userPublisher;
   }

   public String getPublisher() {
      return publisher;
   }

   public void setPublicationDate(String userPublicationDate) {
      publicationDate = userPublicationDate;
   }

   public String getPublicationDate() {
      return publicationDate;
   }

   @Override
   public String toString() {
      return   "Book Information: "                   +
               "\n\tBook Title: "         + title     +
               "\n\tAuthor: "             + author    +
               "\n\tPublisher: "          + publisher +
               "\n\tPublication Date: "   + publicationDate;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;

      Book other = (Book) obj;
      if (author == null) {
         if (other.author != null)
            return false;
      } else if (!author.equals(other.author))
         return false;
      if (publicationDate == null) {
         if (other.publicationDate != null)
            return false;
      } else if (!publicationDate.equals(other.publicationDate))
         return false;
      if (publisher == null) {
         if (other.publisher != null)
            return false;
      } else if (!publisher.equals(other.publisher))
         return false;
      if (title == null) {
         if (other.title != null)
            return false;
      } else if (!title.equals(other.title))
         return false;
      return true;
   }
}

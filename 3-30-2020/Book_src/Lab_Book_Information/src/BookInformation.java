import java.util.Scanner;

public class BookInformation {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      String title, author, publisher, pubDate;
      String eTitle, eAuthor, ePublisher, ePubDate, edition;
      String aTitle, aAuthor, aPub, aPubDate, aLanguage;
      int numVolumes, aLength;

      title = scnr.nextLine();
      author = scnr.nextLine();
      publisher = scnr.nextLine();
      pubDate = scnr.nextLine();

      eTitle = scnr.nextLine();
      eAuthor = scnr.nextLine();
      ePublisher = scnr.nextLine();
      ePubDate = scnr.nextLine();
      edition = scnr.nextLine();
      numVolumes = scnr.nextInt();

      scnr.nextLine();

      aTitle = scnr.nextLine();
      aAuthor = scnr.nextLine();
      aPub = scnr.nextLine();
      aPubDate = scnr.nextLine();
      aLanguage = scnr.nextLine();
      aLength = scnr.nextInt();

      Book myBook = new Book();
      Encyclopedia myEncyclopedia = new Encyclopedia();
      Audio myAudio = new Audio(aTitle, aAuthor, aPub, aPubDate, aLanguage, aLength);

      myBook.setTitle(title);
      myBook.setAuthor(author);
      myBook.setPublisher(publisher);
      myBook.setPublicationDate(pubDate);
      System.out.println(myBook);

      myEncyclopedia.setTitle(eTitle);
      myEncyclopedia.setAuthor(eAuthor);
      myEncyclopedia.setPublisher(ePublisher);
      myEncyclopedia.setPublicationDate(ePubDate);
      myEncyclopedia.setEdition(edition);
      myEncyclopedia.setNumVolumes(numVolumes);
      System.out.println(myEncyclopedia);

      System.out.println(myAudio);
   }
}

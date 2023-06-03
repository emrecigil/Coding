import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class History {
    public static String getHistory(){
        int borrowbooksayi = 0;
        int readbooksayi = 0;
        long printedSayi = AddMandB.books.stream().filter(books -> books.getType().equals("P")).count();
        long handWrittenSayi = AddMandB.books.stream().filter(books -> books.getType().equals("H")).count();
        for (Members s : AddMandB.members){
            borrowbooksayi += s.getBorrowBook().size();
            readbooksayi += s.getReadbooksayi().size();
        }

        List<Integer> printed = AddMandB.books.stream().filter(baski -> baski.getType().equals("P")).map(Books::getId)
                .collect(Collectors.toList());

        String formatliId = IntStream.range(0, printed.size())
                .mapToObj(i -> String.format("Printed [id: %d]", printed.get(i)))
                .collect(Collectors.joining("\n"));

        List<Integer> handwr = AddMandB.books.stream().filter(hw -> hw.getType().equals("H")).map(Books::getId)
                .collect(Collectors.toList());

        String formatliId2 = IntStream.range(0, handwr.size())
                .mapToObj(i -> String.format("Printed [id: %d]", handwr.get(i)))
                .collect(Collectors.joining("\n"));

        List<Integer> student = AddMandB.members.stream().filter(baski -> baski.getType().equals("S")).
                map(Members::getId).collect(Collectors.toList());

        String formatliId3 = IntStream.range(0, student.size())
                .mapToObj(i -> String.format("Student [id: %d]", student.get(i)))
                .collect(Collectors.joining("\n"));

        List<Integer> academic = AddMandB.members.stream().filter(baski -> baski.getType().equals("A")).
                map(Members::getId).collect(Collectors.toList());

        String formatliId4 = IntStream.range(0, academic.size())
                .mapToObj(i -> String.format("Academic [id: %d]", academic.get(i)))
                .collect(Collectors.joining("\n"));
        Members.toString1();
        Members.toString2();
        return String.format("History of library:\n\n"+
                "Number of students: %d\n%s\n\n"+
                "Number of academics: %d\n%s\n\n"+
                "Number of printed books: %d\n%s\n\n" +
                "Number of handwritten books: %d\n%s\n\n"+
                        "Number of borrowed books: %d\n%s\n\n"+
                "Number of books read in library: %d\n%s"
                ,student.size(),formatliId3,academic.size(),formatliId4,
                printedSayi,formatliId,handWrittenSayi, formatliId2,Members.borrow.size()/2
                ,Members.toString1(),Members.read.size()/2,Members.toString2());
    }
}

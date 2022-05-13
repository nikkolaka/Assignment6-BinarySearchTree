
import java.io.IOException;

public class UniqueWords {
    private BookReader book = new BookReader(".\\src\\WarAndPeace.txt");

    public UniqueWords() throws IOException {
        addUniqueWordsToBST();

    }

    public void addUniqueWordsToBST(){
        long duration = 0;
        long start = System.currentTimeMillis();
        MyBinarySearchTree<String> mbst = new MyBinarySearchTree<>();


        for(book.words.first(); book.words.current() != null; book.words.next()){
            if(mbst.find(book.words.current()) == null){
                mbst.add(book.words.current());
            }
        }

        long now = System.currentTimeMillis();
        duration = now - start;
        System.out.println();
        System.out.println("BST Sorted in:" + duration +" ms");
        System.out.println(mbst.size()+" unique words");
        System.out.println(mbst.comparisons+" comparisons");

    }

}

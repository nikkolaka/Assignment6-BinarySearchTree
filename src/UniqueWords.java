
import java.io.IOException;

public class UniqueWords {
    private BookReader book = new BookReader(".\\src\\com\\company\\WarAndPeace.txt");

    public UniqueWords() throws IOException {
        addUniqueWordsToLinkedList();
/*        addUniqueWordsToArrayList();
        addUniqueWordsToOrderedList();*/
    }
    public void addUniqueWordsToLinkedList(){
        long duration = 0;
        long start = System.currentTimeMillis();
        MyLinkedList<String> mll = new MyLinkedList<>();


        for(book.words.first(); book.words.current() != null; book.words.next()){
            if(!mll.contains(book.words.current())){
                mll.addBefore(book.words.current());
            }
        }
        mll.sort();
        long now = System.currentTimeMillis();
        duration = now - start;
        System.out.println();
        System.out.println("MLL Sorted in:" + duration +" ms");
        System.out.println(mll.size()+" unique words");
        System.out.println(mll.comparisons+" comparisons");



    }
/*    public void addUniqueWordsToArrayList(){
        long duration = 0;
        long start = System.currentTimeMillis();
        MyArrayList<String> mal = new MyArrayList<>();
        int index = 0;
        for(book.words.first(); book.words.current() != null; book.words.next()){

            if(!mal.contains(book.words.current())){

                mal.insert(book.words.current(),index);
                index++;
            }
        }
        mal.sort();
        long now = System.currentTimeMillis();
        duration = now - start;
        System.out.println();
        System.out.println("MAL Sorted in:" + duration +" ms");
        System.out.println(mal.size()+" unique words");
        System.out.println(mal.comparisons+" comparisons");


    }
    public void addUniqueWordsToOrderedList(){
        long duration = 0;
        long start = System.currentTimeMillis();
        MyOrderedList<String> mol = new MyOrderedList<>();

        for(book.words.first(); book.words.current() != null; book.words.next()){

            if(!mol.binarySearch(book.words.current())){
                mol.add(book.words.current());
            }
        }
        long now = System.currentTimeMillis();
        duration = now - start;
        System.out.println();
        System.out.println("MOL Sorted in:" + duration +" ms");
        System.out.println(mol.size()+" unique words");
        System.out.println(mol.comparisons+" comparisons");
    }*/
}

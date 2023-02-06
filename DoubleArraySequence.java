/******************************************************************************
 * A DoubleArraySequence is a collection of double numbers.
 * The sequence can have a special "current element," which is specified and
 * accessed through four methods that are not available in the sequence class
 * (start, getCurrent, advance and isCurrent).
 *
 * @note
 *       (1) The capacity of one a sequence can change after it's created, but
 *       the maximum capacity is limited by the amount of free memory on the
 *       machine. The constructor, addAfter,
 *       addBefore, clone,
 *       and concatenation will result in an
 *       OutOfMemoryError when free memory is exhausted.
 *       <p>
 *       (2) A sequence's capacity cannot exceed the maximum integer
 *       2,147,483,647
 *       (Integer.MAX_VALUE). Any attempt to create a larger capacity
 *       results in a failure due to an arithmetic overflow.
 *
 * @note
 *       This file contains only blank implementations ("stubs")
 *       because this is a Programming Project for my students.
 *
 *
 * 
 * @version
 *          January 26, 2023
 ******************************************************************************/
public class DoubleArraySequence implements Cloneable {
    private static final int DEFAULT_CAPACITY = 10;
    // Invariant of the DoubleArraySequence class:
    // 1. The number of elements in the seqeunces is in the instance variable
    // manyItems.
    // 2. For an empty sequence (with no elements), we do not care what is
    // stored in any of data; for a non-empty sequence, the elements of the
    // sequence are stored in data[0] through data[manyItems-1], and we
    // don�t care what�s in the rest of data.
    // 3. If there is a current element, then it lies in data[currentIndex];
    // if there is no current element, then currentIndex equals manyItems.
    private double[] data;
    private int manyItems;
    private int currentIndex;
 
    /**
     * Initialize an empty sequence with an initial capacity of 10. Note that
     * the addAfter and addBefore methods work
     * efficiently (without needing more memory) until this capacity is reached.
     * 
     * @param - none
     * @postcondition
     *                This sequence is empty and has an initial capacity of 10.
     * @exception OutOfMemoryError
     *                             Indicates insufficient memory for:
     *                             new double[10].
     **/
    // Created DoubleArraySequence
    public DoubleArraySequence() {
       data = new double[DEFAULT_CAPACITY];
       manyItems = 0;
       currentIndex = 0;
    }
 
    /**
     * Initialize an empty sequence with a specified initial capacity. Note that
     * the addAfter and addBefore methods work
     * efficiently (without needing more memory) until this capacity is reached.
     * 
     * @param initialCapacity
     *                        the initial capacity of this sequence
     * @precondition
     *               initialCapacity is non-negative.
     * @postcondition
     *                This sequence is empty and has the given initial capacity.
     * @exception IllegalArgumentException
     *                                     Indicates that initialCapacity is
     *                                     negative.
     * @exception OutOfMemoryError
     *                                     Indicates insufficient memory for:
     *                                     new double[initialCapacity].
     **/
    // Get empty sequence with a specified Capacity
    public DoubleArraySequence(int initialCapacity) {
       if (initialCapacity < 0)
          throw new IllegalArgumentException("Capacity cannot be negative");
 
       data = new double[initialCapacity];
       manyItems = 0;
       currentIndex = 0;
    }
 
    /**
     * Add a new element to this sequence, after the current element.
     * If the new element would take this sequence beyond its current capacity,
     * then the capacity is increased before adding the new element.
     * 
     * @param d
     *          the new element that is being added
     * @postcondition
     *                A new copy of the element has been added to this sequence. If
     *                there was
     *                a current element, then the new element is placed after the
     *                current
     *                element. If there was no current element, then the new element
     *                is placed
     *                at the end of the sequence. In all cases, the new element
     *                becomes the
     *                new current element of this sequence.
     * @exception OutOfMemoryError
     *                             Indicates insufficient memory for increasing the
     *                             sequence's capacity.
     * @note
     *       An attempt to increase the capacity beyond
     *       Integer.MAX_VALUE will cause the sequence to fail with an
     *       arithmetic overflow.
     **/
    public void addAfter(double d) {
      if (data.length == manyItems){
         ensureCapacity(manyItems*2);
         }
      int i;

      if(isCurrent()){
         i = currentIndex+1;
      }else{
         i = manyItems;
      }
      for (int j = manyItems-1; j >= i; j++) {
         data[j+1] = data[j];
      }
      data[i] = d;
      manyItems++;
      currentIndex = i;
    }
 
    /**
     * Add a new element to this sequence, before the current element.
     * If the new element would take this sequence beyond its current capacity,
     * then the capacity is increased before adding the new element.
     * 
     * @param element
     *                the new element that is being added
     * @postcondition
     *                A new copy of the element has been added to this sequence. If
     *                there was
     *                a current element, then the new element is placed before the
     *                current
     *                element. If there was no current element, then the new element
     *                is placed
     *                at the start of the sequence. In all cases, the new element
     *                becomes the
     *                new current element of this sequence.
     * @exception OutOfMemoryError
     *                             Indicates insufficient memory for increasing the
     *                             sequence's capacity.
     * @note
     *       An attempt to increase the capacity beyond
     *       Integer.MAX_VALUE will cause the sequence to fail with an
     *       arithmetic overflow.
     **/
    public void addBefore(double element) {
      if (data.length == manyItems){
      ensureCapacity(manyItems*2);
      }
      int i;

      if(isCurrent()){
         i = currentIndex;
      }else{
         i = 0;
      }
      for (int j = manyItems; j > i; j--) {
         data[j] = data[j-1];
      }
      data[i] = element;
      manyItems++;
      currentIndex = i;
    }
 
    /**
     * Place the contents of another sequence at the end of this sequence.
     * 
     * @param addend
     *               a sequence whose contents will be placed at the end of this
     *               sequence
     * @precondition
     *               The parameter, addend, is not null.
     * @postcondition
     *                The elements from addend have been placed at the end of
     *                this sequence. The current element of this sequence remains
     *                where it
     *                was, and the addend is also unchanged.
     * @exception NullPointerException
     *                                 Indicates that addend is null.
     * @exception OutOfMemoryError
     *                                 Indicates insufficient memory to increase the
     *                                 size of this sequence.
     * @note
     *       An attempt to increase the capacity beyond
     *       Integer.MAX_VALUE will cause an arithmetic overflow
     *       that will cause the sequence to fail.
     **/
    public void addAll(DoubleArraySequence addend) {
      if (addend == null){
         throw new NullPointerException("The addend sequence cannot be null");
      }
      

      
      int oldcurrent = currentIndex;
      currentIndex = manyItems;

      for (int i = 0; i < addend.manyItems; i++) {
         addAfter(addend.data[i]);
      }
     
      currentIndex = oldcurrent;
      trimToSize();
      
    }
 
    
    public void advance() {
        if(!isCurrent()){
            throw new IllegalStateException("No current Element");
        }
        currentIndex++;
    }
 
    /**
     * Generate a copy of this sequence.
     * 
     * @param - none
     * @return
     *         The return value is a copy of this sequence. Subsequent changes to
     *         the
     *         copy will not affect the original, nor vice versa.
     * @exception OutOfMemoryError
     *                             Indicates insufficient memory for creating the
     *                             clone.
     **/
    public Object clone() { // Clone a DoubleArraySequence object.
       DoubleArraySequence answer;
 
       try {
          answer = (DoubleArraySequence) super.clone();
       } catch (CloneNotSupportedException e) { // This exception should not occur. But if it does, it would probably
          // indicate a programming error that made super.clone unavailable.
          // The most common error would be forgetting the "Implements Cloneable"
          // clause at the start of this class.
          throw new RuntimeException("This class does not implement Cloneable");
       }
 
       answer.data = (double[]) data.clone();
 
       return answer;
    }
 
    /**
     * Create a new sequence that contains all the elements from one sequence
     * followed by another.
     * 
     * @param s1
     *           the first of two sequences
     * @param s2
     *           the second of two sequences
     * @precondition
     *               Neither s1 nor s2 is null.
     * @return
     *         a new sequence that has the elements of s1 followed by the
     *         elements of s2 (with no current element)
     * @exception NullPointerException.
     *                                  Indicates that one of the arguments is null.
     * @exception OutOfMemoryError
     *                                  Indicates insufficient memory for the new
     *                                  sequence.
     * @note
     *       An attempt to create a sequence with a capacity beyond
     *       Integer.MAX_VALUE will cause an arithmetic overflow
     *       that will cause the sequence to fail.
     **/
    public static DoubleArraySequence catenation(DoubleArraySequence s1, DoubleArraySequence s2) {
       if (s1 == null||s2 == null){
         throw new NullPointerException("One of the sequences is null");
       }

       DoubleArraySequence newSequence = new DoubleArraySequence(s1.manyItems + s2.manyItems);
       newSequence.manyItems = newSequence.data.length;
       newSequence.currentIndex = newSequence.manyItems;

       for (int i = 0; i < newSequence.data.length; i++) {
         if(i<s1.manyItems){
            newSequence.data[i] = s1.data[i];
         }
         else {
            newSequence.data[i] = s2.data[i-s1.manyItems];
         }
      }
      return newSequence;

    }
 
    /**
     * Change the current capacity of this sequence.
     * 
     * @param minimumCapacity
     *                        the new capacity for this sequence
     * @postcondition
     *                This sequence's capacity has been changed to at least
     *                minimumCapacity.
     *                If the capacity was already at or greater than
     *                minimumCapacity,
     *                then the capacity is left unchanged.
     * @exception OutOfMemoryError
     *                             Indicates insufficient memory for: new
     *                             int[minimumCapacity].
     **/
    public void ensureCapacity(int minimumCapacity) {
      int ensuredCapacity;
      if(data.length < minimumCapacity){
         ensuredCapacity = minimumCapacity;
      } else {
         ensuredCapacity = data.length;
      }
      double[] bigArray = new double[ensuredCapacity];
      for (int i = 0; i < data.length; i++) {
         bigArray[i] = data[i];
      }
      data = bigArray;
   }
   
 
    
    public int getCapacity() {
       return data.length;
    }
 
   
    public double getCurrent() {
       if (!isCurrent()){
        throw new IllegalStateException("No current element");
       }
        return data[currentIndex];
    }
 
   
    public boolean isCurrent() { // see if sequence has a specified current element
        
       return this.manyItems != currentIndex;
    }
 
    /**
     * Remove the current element from this sequence.
     * 
     * @param - none
     * @precondition
     *               isCurrent() returns true.
     * @postcondition
     *                The current element has been removed from this sequence, and
     *                the
     *                following element (if there is one) is now the new current
     *                element.
     *                If there was no following element, then there is now no
     *                current
     *                element.
     * @exception IllegalStateException
     *                                  Indicates that there is no current element,
     *                                  so
     *                                  removeCurrent may not be called.
     **/
    public void removeCurrent() {
       if(!isCurrent()){
         throw new IllegalStateException("There is no current element");
       }
       for (int i = currentIndex; i < manyItems; i++) {
         data[i] = data[i+1];
       }
       manyItems--;
    }
 

    public int size() { // Determine the number of elements in this sequence.
 
       return manyItems;
    }
 
  
    public void start() {
        currentIndex = 0;
    }
 
    /**
     * Reduce the current capacity of this sequence to its actual size (i.e., the
     * number of elements it contains).
     * 
     * @param - none
     * @postcondition
     *                This sequence's capacity has been changed to its current size.
     * @exception OutOfMemoryError
     *                             Indicates insufficient memory for altering the
     *                             capacity.
     **/
    public void trimToSize() {
      double[] trimmedArray = new double[manyItems];
      for (int i = 0; i < manyItems; i++) {
         trimmedArray[i] = data[i];
      }
      data = trimmedArray;
    }
 
    public int getCurrentIndex() {
       return currentIndex;
    }
 
    public void setCurrentIndex(int currentIndex) {
       this.currentIndex = currentIndex;
    }
 
    // The new double array sequence is a copy of the DoubleArraySequence src.
    public DoubleArraySequence(DoubleArraySequence src) {
         this.data = new double[src.data.length];
         this.manyItems = src.manyItems;
         this.currentIndex = src.currentIndex;

         for (int i = 0; i < data.length; i++) {
            data[i] = src.data[i];
         }
    }
 }
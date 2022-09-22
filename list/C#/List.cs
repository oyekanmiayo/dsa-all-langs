/*
AUTHOR: Kehinde Ojewale
*/


class List<A>{
    A[] underlyingArray;
    int currentSize;
    double currentThreshhold; //this variable tracks 80% of the underlying array's size
    int currentIndex=0; //this variable tracks the length of items in the list and tells the index a new item will be added to
    

     public List(){
        
        underlyingArray = new A[20]; //initializing an unserlying array to store the elements of the list
        currentSize= underlyingArray.Length;
        currentThreshhold=0.8*currentSize;
        }

    //Method to add an item to the list    
    public void Add(A item){
        if(currentIndex>=currentThreshhold) CreateBiggerArray(1);
        underlyingArray[currentIndex]=item;
        currentIndex++;  
        }

    //Method to add an array of items to the list
    public void AddRange(A[] items){
         if(currentIndex+items.Length>=currentThreshhold) {
            int sizeMultiple;
            sizeMultiple=(currentIndex+items.Length)/currentIndex;
            CreateBiggerArray(sizeMultiple);
         }
         int currentIndexCopy = currentIndex;
         for(int i=0; i<items.Length; i++) {
            underlyingArray[currentIndexCopy+i]=items[i]; 
            currentIndex++;
            }
        }
    //Creates a bigger array once the underlying array's threshhol is reached
    void CreateBiggerArray(int sizeMultiple){
        //sizeMultiple
        int newSize=currentSize*2*sizeMultiple;
        A[] biggerArray=new A[newSize];
        for(int i=0; i<currentIndex;i++){
            biggerArray[i]=underlyingArray[i];
        }
        underlyingArray=biggerArray;
        }
    //Method to add an item at a particular index in the list
    public void Insert(int index, A item){
        if(index>=currentSize) {
        throw new IndexOutOfRangeException(String.Format("Index {0:d} is out of the bounds of the list" , index));
        }
        if(currentIndex>=currentThreshhold) CreateBiggerArray(1);
        A itemToBeReplaced=underlyingArray[index];
        underlyingArray[index]=item;
        int replacementIndex=index+1;
        while (replacementIndex<currentIndex)
        {
            underlyingArray[replacementIndex+1]=underlyingArray[replacementIndex];
            replacementIndex++;
        }
        //ALTERNAATIVE TO WHILE LOOP
        /*
        for(index=index; replacementIndex<currentIndex-index+1; replacementIndex++){
            underlyingArray[index+replacementIndex]=underlyingArray[index+replacementIndex-1];
            }
            */
        underlyingArray[index+1]=itemToBeReplaced;
        currentIndex++;
        }
    
    //Method to add an array of items starting from a particular index in the list
    public void InsertRange(int index, A[] items){
        if(index>=currentSize) {
        throw new IndexOutOfRangeException(String.Format("Index {0:d} is out of the bounds of the list", index));
        }
        
        if(currentIndex+items.Length>=currentThreshhold) {
            int sizeMultiple;
            sizeMultiple=(currentIndex+items.Length)/currentIndex;
            CreateBiggerArray(sizeMultiple);
         }
        
        A itemToBeReplaced =underlyingArray[index];
        int replacementIndex=0;
        
        replacementIndex=index+items.Length;
        while (replacementIndex<currentIndex+items.Length)
        {
            underlyingArray[replacementIndex]=underlyingArray[replacementIndex-items.Length];
            replacementIndex++;
        }
        
        int i=0;
        while(i<items.Length)
        {
            underlyingArray[index+i]=items[i];
            currentIndex++;
            i++;
        }
       

        }
    //Method to retrieve an item from the list using its index
    public A Get(int index){
        if(index>=currentIndex) {
        throw new IndexOutOfRangeException(String.Format("Index {0:d} is out of the bounds of the list: no item with index {0:d}" , index));
        }
        else{
        return underlyingArray[index];
         }
         }
    //Method to remove an item from the list using its index
    public A Remove(int index){
        if(index>=currentSize) {
        throw new IndexOutOfRangeException(String.Format("Index {0:d} is out of the bounds of the list: no item with index {0:d}" , index));
        }
        A item=underlyingArray[index];

        for(int i=1; i<currentIndex-index; i++){
        underlyingArray[index]=underlyingArray[index+i];
            }
        currentIndex--;
        return item;
        }

    //Sorts the list
    public void Sort(){
        A[] temporaryArray = new A[currentIndex];
        for(int i=0; i<currentIndex;i++){
            temporaryArray[i]=underlyingArray[i];
            }
        Array.Sort(temporaryArray);
        for(int i=0; i<currentIndex;i++){
            underlyingArray[i]=temporaryArray[i];
            }
        
        }

    //Generates a slice of the list from a start index to an end index(inclusive)
    public List<A> Slice(int startIndex, int endIndex){

        if (startIndex>currentIndex){

            }
        if (endIndex>currentIndex){
            
            }
        List<A> slicedList=new List<A>();
        while(startIndex<=endIndex) 
        {
        slicedList.Add(underlyingArray[startIndex]);
        startIndex++;
        }
        return slicedList;
        }

    //Reverses the list
    public void Reverse(){
        int startIndex=0;
        int endIndex=currentIndex-1;
        while(startIndex<endIndex){
            A itemToBeReplaced=underlyingArray[startIndex];
            underlyingArray[startIndex]=underlyingArray[endIndex];
            underlyingArray[endIndex]=itemToBeReplaced;
            startIndex++;
            endIndex--;
            }
        }   

    //returns the number of items in the list
    public int Count(){
        return currentIndex;
        }

    }


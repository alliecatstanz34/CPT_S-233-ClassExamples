//sorting algorithms gone over in class 

class Sort
{

    void InsertionSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) 
        { 
            int key = arr[i]; 
            int j = i - 1; 
    
            /* Move elements of arr[0..i-1], that are 
                greater than key, to one position ahead 
                of their current position */
            while (j >= 0 && arr[j] > key) 
            { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 

    void SelectionSort(int arr[])
    {
        int n= arr.length;

        for(int i= 0; i < n-1; i++)
        {
            int min_index = i;

            for(int j = i+1; j < n; j++)
            {
                if(arr[j] < arr[min_index])
                {
                    min_index = j;
                }
            }

            int temp = arr[min_index];
            arr[min_index] =arr[i];
            arr[i] = temp;

        }
    }

    void BubbleSort (int arr[])
    {
        int n = arr.length;
        boolean swap = false;

        for(int i = 0; i < n-1; i++)
        {    
            if(arr[i] > arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swap = true;
            }

            if(swap == false)
                return;

        }
    }
}
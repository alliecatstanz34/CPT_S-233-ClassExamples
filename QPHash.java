


class QPHash{

    static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    static void hashing(int htable[], int tsize, int arr[], int size){

        //iterate through array 
        for(int i = 0; i < size; i++){

            //computing the hash value 
            int hvalue = arr[i] % tsize;

            //insert into the table if no collisions 
            if(htable[hvalue] == -1){
                htable[hvalue] = arr[i];
            } else { // quadratic probing 
                for (int j = 0; j < tsize; j++){
                    int newHvalue = (hvalue +(j*j)) % tsize;

                    if(htable[newHvalue] == -1){
                        htable[newHvalue] = arr[i];
                        break;
                    }
                }
            }


        }

        printArray(htable);

    }

    public static void main(String args []){

        int array[] = {50,700,76,85,92,73,101};
        int n = 7;
        int l = 11;
        
        int hashTable[] = new int [l];

        for(int i = 0; i < l; i++){
            hashTable[i] = -1;
        }

        printArray(array);

        hashing(hashTable, l, array, n);
    }

}
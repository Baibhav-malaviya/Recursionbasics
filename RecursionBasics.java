public class RecursionBasics {
    public static void printNumInc(int n){
        if(n==1){
            System.out.print(n);
            return ;
        }
        printNumInc(n-1);
        System.out.print(n);
    }
    public static void printNUmDec(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n);

        printNUmDec(n-1);
    }
    public static int printFact(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*printFact(n-1);
    }
    public static int printSum(int n){
        if(n==1){
            return 1;
        }
        return n+printSum(n-1);
    }
    public static int printFabonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return printFabonacci(n-1)+printFabonacci(n-2);
    }
    public static boolean checkSortedArray(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>=arr[i+1]){
            return false;
        }

        return  checkSortedArray(arr,i+1);
    }
    public static int findFirstOccurance(int arr[],int i,int key){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return findFirstOccurance(arr,i+1,key);
    }
    public static int findLastOccurance(int arr[],int i,int key){
        if(i==arr.length){
            return -1;
        }
    int found=findLastOccurance(arr,i+1,key);
        if(found!=-1){
            return found;
        }
        if(arr[i]==key){
            return i;
        }
        return found;
    }
    public static int findexpo(int x,int n){
        if(n==1){
            return x;
        }
        return x*findexpo(x,n-1);
    }
    public static int tilingProblem(int n){
        if(n==0 || n==1){
            return 1;
        }
        //for vertical arrangement
        int fnm1=tilingProblem(n-1);
        //for horizontal arrangement
        int fnm2=tilingProblem(n-2);
        int total=fnm1+fnm2;
        return total;
    }
    public static void removeDuplicate(int i,String str,StringBuilder newStr,boolean arr[]){
        if(i==str.length()){
            System.out.println(newStr);
        }
        if(arr[str.charAt(i)-'a']==true){
            removeDuplicate(i+1,str,newStr,arr);
        }else {
            arr[str.charAt(i)-'a']=true;
            removeDuplicate(i+1,str,newStr.append(str.charAt(i)),arr);
        }
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
   public static void mergeSort(int arr[],int l,int h){
        int mid=(l+h)/2;
        if(l>=h){
            return;
        }
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,h);
        merge(arr,l,mid,h);
   }
   public static void merge(int arr[],int l,int mid,int h){
        int temp[]=new int[h-l+1];
         int i=l;
        int j=mid+1;
        int k=0;
        while (i<=mid && j<=h){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        while ( i<=mid){
            temp[k++]=arr[i++];
        }
        while ( j<=h){
           temp[k++]=arr[j++];
        }
        for(i=l,k=0;k<temp.length; i++,k++){
            arr[i]=temp[k];
        }
   }
   public static void quickSort(int arr[],int l,int h){
        if(l>=h){
            return;
        }
        int pidx=partition(arr,l,h);
        quickSort(arr,l,pidx-1);
        quickSort(arr,pidx+1,h);
   }
   public static int partition(int arr[],int l,int h){
        int pivot=arr[h];
        int i=-1;
        for(int j=0;j<h;j++){
            if(arr[j]<pivot){
                int temp=arr[j];
                arr[j]=arr[++i];
                arr[i]=temp;

            }
        }
        int temp=arr[++i];
        arr[i]=arr[h];
        arr[h]=temp;
        return i;
   }

    public static void main(String[] args) {
        int arr[]={2,6,9,11,12,0,3};
    quickSort(arr,0,arr.length-1);
    printArr(arr);
    }
}

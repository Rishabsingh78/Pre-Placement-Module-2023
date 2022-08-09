class Solution {
    
     int search(int[] nums , int target){
        int pivot=findpivot(nums);
        if(pivot==-1){
            return binarySearch(nums, target , 0, nums.length-1);
        }
       else if(nums[pivot] == target){
            return pivot;
        }
       else if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot-1);
        }
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }
    
     int findpivot(int[] arr){
        int start=0;
        int end=arr.length;
        while(start<=end){
            int mid= start + (end - start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return arr[mid];
            }
            else if(start<mid && arr[mid-1]>arr[mid]){
                return mid;
            }
            else if(arr[start]>=arr[mid]){
                end=mid-1;
            }
            else if(arr[start]<arr[mid]){
                start=mid+1;
            }
        }
        return -1;
    }
    
     int binarySearch(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid= start + (end-start)/2;
            if(arr[mid]<target){
                start=mid+1;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }
            else
                return mid;
        }
        return -1;
    }
    
}

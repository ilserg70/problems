#include "stdafx.h"
#include "iostream"
using namespace std;

//Problem2
//Array contains integer numbers. Find subarray with max sum of elements.
//Example: {-4, 0, 3, 2, 5, -1, 8, 0, -3} => {3, 2, 5, -1, 8}, with sum=17
//Solution O(n)
void GenerateRandomArr(int* arr, int len, int maxElem)
{
	if(arr && len>0 && maxElem > 0)
	{
		int mod = 2*maxElem+1;
		int p;
		for(int i=0; i<len; i++)
		{
			arr[i] = rand()%mod-maxElem;
			p = arr[i];
		}
	}
}
void PrintArray(int* arr, int start, int end)
{
	cout<<"\narr={ ";
	if(arr && end-start >= 0)
	{
		for(int i=start; i<=end; i++)
		{
			if(i>start)
				cout<<", ";
			cout<<arr[i];
		}
	}
	cout<<"}";
}

//Kadane's algorithm consists of a scan through the array values, computing at each position
//the maximum subarray ending at that position. This subarray is either empty 
//(in which case its sum is zero) or consists of one more element than the maximum subarray
//ending at the previous position.
//O(n)
int MaxSumOfSubArray(int* arr, int len, int& start, int& end)
{
		if(!arr || len <= 0)
			return 0;

        start = end = 0;//start and end of subarray
        int start_temp = 0;

        int max_so_far  = arr[0], max_ending_here = arr[0];
 
        // Find sequence by looping through
        for(int i = 1; i < len; i++)
        {
            if(max_ending_here < 0)
            {
                max_ending_here = arr[i];
                start_temp = i;
            }
            else
                max_ending_here += arr[i];

            if(max_ending_here >= max_so_far )
            {
                max_so_far  = max_ending_here;
                start = start_temp;
                end = i;
            }
        }
        return max_so_far;
}

void Test_MaxSumOfSubArray(int len, int maxElem)
{
	if(len<=0 || maxElem <= 0)
		return;
	int* arr = new int[len];
	GenerateRandomArr(arr, len, maxElem);
	PrintArray(arr, 0, len-1);

	cout<<"\n\nTest max sum of subarray. O(n)";
	int start, end;
	int max_sum =  MaxSumOfSubArray(arr, len, start, end);
	cout<<"\nmax_sum="<<max_sum;
	PrintArray(arr, start, end);

	if(arr)
		delete[] arr;
}

int _tmain(int argc, _TCHAR* argv[])
{
	Test_MaxSumOfSubArray(50,2);

	cout<<"\n";
	return 0;
}


#include<iostream>
#include <cstdlib> 
#include <ctime> 

using namespace std;

int main(){
	int arr[36];
	int topic[7];
	
	for (int i = 0; i<6; i++) topic[i] = 0;
	
	for (int i = 0; i<35; i++) arr[i] = 0;
	
	string brr[36] = {"","Ankur","Soumya","Sattwika","Raushan","Tejashwini","Praveen","Shriti","Varun","Tripti","Varsha","Aditya","Charan yadav", 
	"Deepro","Monika","kanak","Venkatesh","Venkat","Sunil","Lakshmi","Ranjana","Charan Reddy","Guru","Likhith","Shreekanta","Abhishek","Zeeshan",
	"Srikalyani","priya","Shanthi","Usha","Neha","Uma","Avisha","Deepak","Bhatu"} ;
	
	srand(time(0));
	int count = 0;
	int flag = 0;
	int index = 2;
	cout<<"Group 1: ";
	while(count < 35 ){
		float temp = (float)rand()/RAND_MAX;
	     int ans = 35*temp + 1;
	     if (arr[ans] == 0){
	     	arr[ans]++;
	     	cout<<brr[ans]<<", ";
	     	count++;
	     	flag++;
	     	if (flag == 6){
	     		
	     		flag = 0;
	     		cout<<endl;
	     		cout<<"Group "<<index<<": ";
	     		index++;
			 }
		 }
	}

return 0;
	
}




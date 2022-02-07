#include<iostream>

using namespace std;

int main(){
int num;                                        //number that we want to reverse
cin>>num;                                       // taking input from user
int temp = num;                                 //creating a new variable temp 
int rev = 0;                                   // creating a another variable for storing reverse number
while(temp>0){
rev = temp%10 + rev*10;
temp = temp/10;
}

cout<<rev<<endl;

return 0;
}

# Group3BookRentalApp
git init :----------------- initializing your new repo

git clone : to clone this repository's url

git config --global user.email "your emali address":--------configure the repo with your credentials to make easier to acknowledge each other's code.

git checkoout -b "TheNameOfYourBranch" example branch name "feature/addCustomer" :------------- To create a new branch

git fetch and git pull:-------- to ensure that you have the lastest update from the repo before you start writing your code
when you push your code to the repository, create a pull request so the code can be reviewed before merging


               Project Structure
              a)  Model layer ------- which are just plain old java object to use in the DAO and Service layers as needed.
               The 2 most important models that we will use for this project are: Books and Customers.
               
              b) DAO layer ------  include a class for Connection to the database and a class for the actual crud operation.
              
              c) Service layer --------- where we call the DAO layer's methods and take user input and so forth
              
              d) Main class where we call the service layer. We also implemented the application GUI in the main class 
               
       

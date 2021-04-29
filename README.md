To compile:
- clone repo
- mvn install in command line

To run:
- first start up the app in Intellij
- then send a request to: http://localhost:8080/tic-tac-toe/who_goes_first?user_goes_first=BOOLEAN
 with BOOLEAN either as true or false depending on if user wants to make the first step
- afterwards make your steps using http://localhost:8080/tic-tac-toe/user_chooses?chosen_step=1 if you want to step on position 1. (That is equivalent to the 0th position of the underlying array.) The logging in the console will correspond to the indices of the array not the chosen position by user.
------Travel Packing List Manager
This is a simple Android application built for a class project. It helps you manage a packing list for your travels. You can add items with details like category and quantity, and then view your list in different ways.
Project Goal
The main goal of this project was to learn the fundamentals of building a native Android app using Kotlin and Jetpack Compose. The requirements were to create a two-screen application that uses parallel arrays to store data, handle user input, and navigate between screens.
Features
•	Add Items: On the main screen, you can enter the details of a packing item (name, category, quantity, and comments).
•	View Full List: Navigate to a second screen to see a complete list of all the items you have added.
•	View Filtered List: On the same screen, you can filter the list to show only the items where you are packing two or more (Quantity >= 2).
•	Simple Navigation: Easily switch between the "Add Item" screen and the "View Lists" screen.
•	Exit the App: A button to safely close the application.
•	Error Handling: The app checks for simple errors, like empty fields or invalid numbers for quantity, and shows a helpful message.
How to Use the App
1.	When you first open the app, you will be on the main screen.
2.	Fill in the details for a packing item in the four text boxes: "song," "artist," "rating," and "Comments."
3.	Click the "Add to Packing List" button. The item will be saved, and the text fields will clear. If you make a mistake (like leaving a field blank), an error message will appear.
4.	To see your lists, click the "View Packing Lists" button.
5.	On the next screen, click "Display Full List" to see everything or "Items (Qty 2+)" to see the filtered list.
6.	Click "Return to Main Screen" to go back.
7.	Click "Exit App" to close the application.
      How to Run This Project
      To run this project, you will need Android Studio.
1.	Clone this repository or download the source code.
2.	Open Android Studio.
3.	Click on File > Open and navigate to the folder where you saved the project.
4.	Let Android Studio build the project (this may take a minute).
5.	Run the app on an Android emulator or a physical Android device.
      What I Learned from This Project
      •	State Management: How to use ViewModel and mutableStateOf to manage the data and state of the application.
      •	Jetpack Compose Basics: Building a user interface from scratch using composable functions.
      •	Kotlin Fundamentals: Using lists, functions, and simple error handling in Kotlin.
      •	App Navigation: Setting up and using a NavController to move between different screens in a Compose app.
      •	Clean Code: How to structure an app by separating UI from logic.
-----------------------------------------
# UK-Restraurants-App
Application that retrieves a Json Array of Nottingham Bars , clubs and restaurants and displays them on the correct location with google maps api. Application also contains a bottom navigation to navigate to a list of these locations for a more detailed view.
# Features
* Get json array list of Nottingham spots from http://www.wyredata.com/documentation with Volley Library
* Display google maps
* Set the correct location of the retrieved data in google maps
* Naviagte to different fragments
* Display list of spots along with their respective information in recycler view.
# Technical Feature
* The Application is written in java and implements MVC architecture while utilizing volley library to reteive json array of data and display on google maps api.
# App Packages
* Adapter: To hold all the adapter logic
* Controller: To hold logic such as getRequestQueue and addToRequestQueue
* Data: Contains the repository logic thats responsible for getting the api data with volley library aswell as the Async response
* Model: Contains The classes for the retrieved json api objects
* Util. Contains logic to retieve park url and hide soft keyboard
* nottinghamrestaurants: Contains Details fragment, maps activity and restaurant fragment logic
# Library References
* Lifecycle Jetpack library
* Live Data Jetpack library
* Volley Library
* Picasso Library
# App Images
![google maps](https://user-images.githubusercontent.com/56201348/123563053-55dea980-d7aa-11eb-905a-d81d54badc24.jpg)
![spots ](https://user-images.githubusercontent.com/56201348/123563056-58d99a00-d7aa-11eb-9364-104574b6d82d.jpg)
![spot display](https://user-images.githubusercontent.com/56201348/123563057-5aa35d80-d7aa-11eb-965f-fb6794c70760.jpg)

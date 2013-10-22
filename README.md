Introduction

These days the purpose of a cell phone is more important that just calling or receiving text messages. 
It’s the era of smart phones which are more useful and efficient and hence are a part of user’s life.
Smart phones not only help you socialize and serve the purpose of a normal phone they also help users at work by their useful features and efficient applications.
Misplacing or losing them can really harm the user in a lot of ways.
So an android tracking device can be really helpful.
In android devices space and time complexity are very important.
Users always look for efficient applications which are not only fast but also occupy less space. 
Keeping this in mind the paper was designed. Usually device tracking applications are slow and don’t work with the same efficiency on all android versions. 
Android tracking devices are of great help to the users. One of the main features in all the android smart phones is availability of GPS by which it can show the location of the cell phone.
Using this property the application gives the location of the cell so that the user can track its lost cell phone. 
Apart from this the application can get the cell phone to ring even if it is in silent mode that can help users to locate the cell phone. 
The application gets activated only if the user texts the keyword and the user can set the keyword according to their convenience and set words that are easy for them to remember.

Why Android?

Android operating system has gained a lot of popularity recently. 
According to a research conducted by Kantar Worlpanel Comtech 51.2% of all the smart phone users use android OS while 43.5% of them are using iOS. 
These statistics are good enough for us to realize that the market of android operating system is expanding at a fast pace and making an application on this platform will reach to a larger number of people And in many ways it is more efficient than all the other available mobile operating system. 
After original release there have been number of updates in the original version of Android. It is the software stack of mobile devices. Android SDK provides the API's that is necessary to begin developing applications on the Android platform using the Java programming language. Android includes an embeddable browser built upon Web Kit, the same open source browser engine powering the iPhone's Mobile Safari browser. 
There are following broad classifications in android based applications

Activities

From the home screen whenever an application is selected first the activity is launched.
It is the part by the help of which the UI is implemented.

Boot-Up Receiver

The application starts on boot-up automatically and need not be started manually every time.

Content Provider

Basic job is to manage access to a persisted data. 
Usually comes into the picture when an application makes use of SQLite Database.

Broadcast receiver

It is basically launched to process a data element usually after occurrence of an event like receiving a text message.
All these are the main building blocks of an android application.
The architecture of android applications is really simple and that is the reason the number of android applications are higher than other operating systems.

Working of the app

This app really justifies its name “The Eye”, as it virtually has its watchful eyes on your device all the time. There are instructions which make this app very user-friendly. 
After installing the app and then opening it for the first time, the user gets a prompt to set the keywords for ring and GPS respectively in their particular areas. After saving, the app becomes active and henceforth it hunts for the keyword in all the incoming messages.

How does it actually work?

Before we dig deep into the technicalities, let’s zoom out a little and look at d generalized working of the app.
But before that, one may wonder "what's the need to find a phone? If I have one it'll be in my pocket all the time!"
Since the invention of phones, our dependency on them has also increased to a greater extent and people have become more forgetful of their phones as compared to the times earlier.
And then came a new generation of phones appropriately called as the "smart phones" which gave a whole new meaning to our lives. A phone doesn't mean just communication nowadays. We can plan our whole day on it. We expect a lot from our phones now!
And thus, they need to be smarter!
And this app adds to the smartness of these phones.
The app starts up at d time of system boot and runs as a background activity throughout the system’s active time.
On the first user login to the app, the user has to set a "trigger" keyword that is later on used in the effective working of the app.
That's it!!! The user need not do anything further except to remember the trigger keyword of course!
Now, whenever the device is misplaced, the owner has to just text the keyword to his device from any other cell phone and this app makes his phone either ring (even in silent mode!) or send the GPS coordinates of his phone to the above mentioned secondary cell phone. The details of the two main feature of the app is given below-
Main Features:-
 Automatic Ringer Tone
 GPS Tracking

Ringer: - The “ringer” is one of the most important features that the app promises to provide. Now the first question that strikes our minds is “what unique feature is it to make a phone ring? It already does so, isn’t it?” Here’s where the app’s ability comes in the foreground.
We use the audio manager class and some of its objects to get our cell to ring.

final Audio Manager mAudio = (Audio Manager) getSystemService (Activity.AUDIO_SERVICE);
mAudio.setRingerMode (AudioManager.RINGER_MODE_NORMAL);
Notification = RingtoneManager.getDefaultUri (RingtoneManager.TYPE_RINGTONE);

GPS: - Mobile phone tracking refers to the attaining of the current position of a mobile, stationary or moving. Localization may occur either via multiple iterations of locating the phone by sending radio signals between (several) radio towers of the network and the phone, or simply via GPS.
The technology of locating is based simply on the logic that a phone communicates with its nearest radio tower. So, the location of the phone could be figured out in that way! Usually, there are 3 basic tracking methods
prevalent in use.
Namely, Network-based (uses the service provider’s network to identify location) , Handset-based (requires installing client technology to use its benefits) and SIM-based (uses the SIM’s GSM or CDMA technology based on radio transmission).
But, after the research on various tracking systems, we infer that HYBRID based technology is most beneficial for tracking purposes.
But what is “hybrid” technology anyways?
The HYBRID based tracking technology uses both “GPS” as well as the network provider to locate any device. This proves to be more efficient as compared to other methods, as is obvious by the fact that it mixes up the logic of more than 1 technology and hence becomes less error prone.
In “The Eye”, we make use of this hybrid technology to track the location of our device.
Firstly, the device receives a trigger from any secondary device and the network provider of the device comes into play. The device then tracks the GPS coordinates of itself, while GPS is enabled on it and sends back the information back to the secondary device in the form of a text message.
If in case, the GPS is disabled on the android device, this app prompts the user to enable it.

if(gps.canGetLocation()){
double latitude = gps.getLatitude();
double longitude = gps.getLongitude();
}

Summary

Although there are many android tracking applications found but they either occupy a lot of more or do not work efficiently on all the android versions. 
This application tries to works on both these problems and even plans to develop it further and make it better than the other applications available.
The project is used to demonstrate the idea of a smart android tracking device that can store the keyword without using a data base and can efficiently track the phone’s location.
Many more features can be added to this application to make it more efficient and attractive to the users. The current application is under further development to add features like camera activation, password protection of the app and the like. 
We are thinking to incorporate more such features into the application. This application can prove to be a really helpful and after further development it will attract more android users to us it.

Future Scope-

We all know that Android is a rising technology and hence, we believe that it can prove to provide a better scope for further developments in this app.
The features that Android programming provides along with its hardware compatibility, has led to the inception of some ideas which could be implemented as an added advantage for “The Eye”. Some of those would be as follows-
 Camera enabled tracking – Along with GPS tracking of the device, the camera of the phone could also be enabled automatically so as to get the snaps of the immediate vicinity of the phone. This would help in better location of the device.
 Controlling activities like calls, SMS or alarms – In case the user is sure about theft of the device, an option to control all the important activities would be a good option and also in terms with security & privacy of private data.
 SIM Card blocking – We like to call it “The Self Destruct Mode”. And as the name suggests, In case there is no hope of retrieving the lost device, this feature could come into play and destroy sensitive & confidential data from the phone.
 Password protection- A very good security feature in "The Eye" would be being able to enable password protection of the device remotely. In that way, as soon as the user realizes the loss of his device, he could enable the password protection feature to avoid further damage and prevent unwanted users from accessing it.

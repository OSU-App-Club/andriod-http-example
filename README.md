android-http-example
====================

This is an example of how to fetch json through an http request asynchronously.
I have added my personal project built in Android Studio as well as a folder containing only the raw sources you would need to setup in Eclipse.


Included:

- android-http-example project (Built using Android Studio)

- JustTheFiles folder, which contains just the modified files so you can reconstruct this project in Eclipse. 

•string.xml goes in your 'res/values' directory of your project

•Both MainActivity.java & RetrieveJson.java go in your src

•activity_main.xml is a layout, which goes in 'res/layout'


Also concerning the AndroidManifest.xml the only important bit you need to see (and use) is the following:

<uses-permission android:name="android.permission.INTERNET"/>

Without this your application WILL crash when it attempts to pull anything.

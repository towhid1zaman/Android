>**What are Android Notifications?**

Notification is a short message that we see outside of our application UI. Notifications are reminders for the app event that is invoked even when application is not running.

Notification usually come from remotely. Lets say, whatsapp notification come from whatsapp cloud, that is backend server.


To display notification from a application need 3 things,

1. Notification  Channel:  Required on Android 8.0 (API level 26) and higher; it groups notifications and lets users control importance levels.

2. Notification Builder: Used to build notifications with essential attributes, like title, text, and icon.

3. Notification Manager: Handles the notification display; you call it to send the notification.

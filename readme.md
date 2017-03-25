# Android ChatLib
ChatLib is a helper library to add chat functionality in Android app. The library provides all features that are essential in developing chat module in an application.

### Background
In recent past, I came across many clients who wanted to have chat like feature in their apps. The goal was to develop a helper library that allows following:
- A library that can be quickly added for chat based requirement (plug and play)
- Easy to understand code and seamless integration
- Enable integration with third party chat frameworks without changing much code
- Ensure extensibility

### What it includes?
The library has follwing items that are required in any chat module:
  - Chat Bubbles
  - General screen for chat list and messages
  - Support for textual chat and media (images).
  - Chat list sorting based on recent time

### Usage
##### Chat List screen
In order to add chat list screen screen to your app extend your fragment with `ChatListBaseFragment` and override methods to provide your own customised views/implementaiton.
  - Return layout resource id of your fragment in `getChatLayoutResource`.
  - To show chat list in listview, return listview id in `getListviewId`
  - You can also provide custom implementation of chat list adapter by extending your adapter with `ChatListBaseAdap`

### Todo
 - Add base implementation of message screen
 - Add proper documentation.





<p align="center">
  <img src=/app/src/main/res/drawable/headlamp.png/>
</p>
### _Epicodus: Android (Week 1: Friday, Independent Project)_

#### By _[**Caleb Stevenson**](https://github.com/CGrahamS)_

## Description

This app allows Minecraft players to check the status of a server and look up some details about fellow Minecraft players.

## Specs

| BEHAVIOR                                         | INPUT    | OUTPUT   |
|--------------------------------------------------|----------|----------|
| Program navigates to different application views |          |          |

## Setup/Installation Requirements

1. Clone this repository to your desktop `git clone https://github.com/CGrahamS/headlamp.git`
2. Open repository in Android studio.
3. Confirm Gradle build is successful.
4. Create a new AVD with the 4" WVGA (Nexus S) profile.
5. Select the Marshmallow, API Level: 23, ABI x86
6. Remove '4"' from the AVD name.
7. Now you can Run the app!

## Known Bugs

* The list view in the ServerDetailsActivity formats first two items of the supplied array with the first argument twice. Likely because the variable names are not unique. This results in an incorrect offset, supplying values to the wrong labels.

## Support and contact details

Caleb Stevenson: _cgrahamstevenson@gmail.com_

## Technologies Used

_Java,
Android,
ButterKnife_

### License

This webpage is licensed under the GPL license.

Copyright &copy; 2016 **_Caleb Stevenson_**

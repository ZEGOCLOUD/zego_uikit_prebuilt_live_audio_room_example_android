# Overview

- - -


**Live Audio Room Kit** is a prebuilt component that helps you to build full-featured live audio rooms into your apps easier.

And it includes the business logic along with the UI, enabling you to customize your live audio apps faster with more flexibility. 


<img src="https://doc.oa.zego.im/Pics/ZegoUIKit/Flutter/audio_room/final_sublist.gif" >


## When do you need the Live Audio Room Kit

- When you want to build live audio rooms easier and faster, it allows you:
    > Build or prototype live audio apps ASAP

    > Finish the integration in the shortest possible time

- When you want to customize UI and features as needed, it allows you:
    > Customize features based on actual business needs

    > Spend less time wasted developing basic features

    > Add or remove features accordingly 


To build a live audio app from scratch, you may check our [Voice Call](https://docs.zegocloud.com/article/5554).



## Embedded features

- Ready-to-use Live Audio Room
- Remove speakers
- Speaker seats changing
- Customizable seat layout
- Extendable menu bar
- Device management
- Customizable UI style
- Real-time interactive text chat


## Integrate the SDK

### Add ZegoUIKitPrebuiltLiveAudioRoom as dependencies

1. Add the `jitpack` configuration.
- If your Android Gradle Plugin is **7.1.0 or later**: enter your project's root directory, open the `settings.gradle` file to add the jitpack to `dependencyResolutionManagement` > `repositories` like this:

``` groovy
dependencyResolutionManagement {
   repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
   repositories {
      google()
      mavenCentral()
      maven { url 'https://www.jitpack.io' } // <- Add this line.
   }
}
```

 ### Note:

If you can't find the above fields in `settings.gradle`, it's probably because your Android Gradle Plugin version is lower than v7.1.0. 


- If your Android Gradle Plugin is **earlier than 7.1.0**: enter your project's root directory, open the `build.gradle` file to add the jitpack to `allprojects`->`repositories` like this: 

```groovy
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }  // <- Add this line.
    }
}
```

2. Modify your app-level `build.gradle` file:
```groovy
dependencies {
    ...
    implementation 'com.github.ZEGOCLOUD:zego_uikit_prebuilt_live_audio_room_android:1.0.0'    // Add this line to your module-level build.gradle file's dependencies, usually named [app].
}
```  

### Using the Live Audio Room Kit

- Specify the `userID` and `userName` for connecting the Live Audio Room Kit service. 
- Create a `roomID` that represents the live audio room you want to create.


 ### Note：

- `userID`, `userName`, and `roomID` can only contain numbers, letters, and underlines (_). 
- Using the same `roomID` will enter the same live audio room.


With the same `roomID`, only one user can enter the live audio room as host. Other users need to enter the live audio room as the audience.

```java
public class LiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        addFragment();
    }

    public void addFragment() {
        long appID = yourAppID;
        String appSign = yourAppSign;
        String userID = yourUserID;
        String userName = yourUserName;

        boolean isHost = getIntent().getBooleanExtra("host", false);
        String roomID = getIntent().getStringExtra("roomID");

        ZegoUIKitPrebuiltLiveAudioRoomConfig config;
        if (isHost) {
            config = ZegoUIKitPrebuiltLiveAudioRoomConfig.host();
        } else {
            config = ZegoUIKitPrebuiltLiveAudioRoomConfig.audience();
        }

        ZegoUIKitPrebuiltLiveAudioRoomFragment fragment = ZegoUIKitPrebuiltLiveAudioRoomFragment.newInstance(
            appID, appSign, userID, userName,roomID,config);
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitNow();
    }
}
```

Then, you can create a live audio room by starting your `LiveActivity`.

## Related guide
[Custom Prebuilt UI](https://docs.zegocloud.com/article/15082)


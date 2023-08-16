# TikTok-Live-Java
A Node.js library to receive live stream events such as comments and gifts in realtime from [TikTok LIVE](https://www.tiktok.com/live) by connecting to TikTok's internal WebCast push service. The package includes a wrapper that connects to the WebCast service using just the username (`uniqueId`). This allows you to connect to your own live chat as well as the live chat of other streamers. No credentials are required. Besides [Chat Comments](#chat), other events such as [Members Joining](#member), [Gifts](#gift), [Subscriptions](#subscribe), [Viewers](#roomuser), [Follows](#social), [Shares](#social), [Questions](#questionnew), [Likes](#like) and [Battles](#linkmicbattle) can be tracked. You can also send [automatic messages](#send-chat-messages) into the chat by providing your Session ID.


Do you prefer other programming languages?
- **Node** orginal: [TikTok-Live-Connector](https://github.com/isaackogan/TikTok-Live-Connector) by [@isaackogan](https://github.com/isaackogan) 
- **Python** rewrite: [TikTokLive](https://github.com/isaackogan/TikTokLive) by [@isaackogan](https://github.com/isaackogan)
- **Go** rewrite: [GoTikTokLive](https://github.com/Davincible/gotiktoklive) by [@Davincible](https://github.com/Davincible)
- **C#** rewrite: [TikTokLiveSharp](https://github.com/frankvHoof93/TikTokLiveSharp) by [@frankvHoof93](https://github.com/frankvHoof93)

**NOTE:** This is not an official API. It's a reverse engineering project.

#### Overview
- [Getting started](#getting-started)
- [Params and options](#params-and-options)
- [Methods](#methods)
- [Events](#events)
- [Examples](#examples)
- [Contributing](#contributing)

## Getting started

1. Install the package via NPM
```
npm i tiktok-live-connector
```

2. Create your first chat connection

```java
  public static void main(String[] args)
  {
     // Username of someone who is currently live
     var tiktokUsername = "officialgeilegisela";

     TikTokLive.newClient(tiktokUsername)
                .onConnected(event ->
                {
                    System.out.println("Connected");
                })
                .onJoin(event ->
                {
                    System.out.println("User joined -> " + event.getUser().getNickName());
                })
                .onComment(event ->
                {
                    System.out.println(event.getUser().getUniqueId() + ": " + event.getText());
                })
                .onError(event ->
                {
                    event.getException().printStackTrace();
                })
                .buildAndRun();
    }
```

## Methods
A `TikTokLive` object contains the following methods.

| Method Name | Description |
| ----------- | ----------- |
| connect     | Connects to the live stream chat.<br>Returns a `Promise` which will be resolved when the connection is successfully established. |
| disconnect  | Disconnects the connection. |
| getRoomInfo | Gets the current room info from TikTok API including streamer info, room status and statistics. |

## Events

A `TikTokLive` object has the following events 

Events:
-  [a](https://github.com/jwdeveloper/TikTok-Live-Java/blob/master/API/src/main/java/io/github/jwdeveloper/tiktok/events/messages/TikTokBarrageMessageEvent.java)
-  [TikTokLinkMicFanTicketEvent](#TikTokLinkMicFanTicketEvent)
-  [TikTokEnvelopeEvent](#TikTokEnvelopeEvent)
-  [TikTokShopMessageEvent](#TikTokShopMessageEvent)
-  [TikTokDetectMessageEvent](#TikTokDetectMessageEvent)
-  [TikTokLinkLayerMessageEvent](#TikTokLinkLayerMessageEvent)
-  [TikTokConnectedEvent](#TikTokConnectedEvent)
-  [TikTokCaptionEvent](#TikTokCaptionEvent)
-  [TikTokQuestionEvent](#TikTokQuestionEvent)
-  [TikTokRoomPinMessageEvent](#TikTokRoomPinMessageEvent)
-  [TikTokRoomMessageEvent](#TikTokRoomMessageEvent)
-  [TikTokLivePausedEvent](#TikTokLivePausedEvent)
-  [TikTokLikeEvent](#TikTokLikeEvent)
-  [TikTokLinkMessageEvent](#TikTokLinkMessageEvent)
-  [TikTokBarrageMessageEvent](#TikTokBarrageMessageEvent)
-  [TikTokGiftMessageEvent](#TikTokGiftMessageEvent)
-  [TikTokLinkMicArmiesEvent](#TikTokLinkMicArmiesEvent)
-  [TikTokEmoteEvent](#TikTokEmoteEvent)
-  [TikTokUnauthorizedMemberEvent](#TikTokUnauthorizedMemberEvent)
-  [TikTokInRoomBannerEvent](#TikTokInRoomBannerEvent)
-  [TikTokLinkMicMethodEvent](#TikTokLinkMicMethodEvent)
-  [TikTokSubscribeEvent](#TikTokSubscribeEvent)
-  [TikTokPollMessageEvent](#TikTokPollMessageEvent)
-  [TikTokFollowEvent](#TikTokFollowEvent)
-  [TikTokRoomViewerDataEvent](#TikTokRoomViewerDataEvent)
-  [TikTokGoalUpdateEvent](#TikTokGoalUpdateEvent)
-  [TikTokCommentEvent](#TikTokCommentEvent)
-  [TikTokRankUpdateEvent](#TikTokRankUpdateEvent)
-  [TikTokIMDeleteEvent](#TikTokIMDeleteEvent)
-  [TikTokLiveEndedEvent](#TikTokLiveEndedEvent)
-  [TikTokErrorEvent](#TikTokErrorEvent)
-  [TikTokUnhandledEvent](#TikTokUnhandledEvent)
-  [TikTokJoinEvent](#TikTokJoinEvent)
-  [TikTokRankTextEvent](#TikTokRankTextEvent)
-  [TikTokShareEvent](#TikTokShareEvent)
-  [TikTokUnhandledMemberEvent](#TikTokUnhandledMemberEvent)
-  [TikTokSubNotifyEvent](#TikTokSubNotifyEvent)
-  [TikTokLinkMicBattleEvent](#TikTokLinkMicBattleEvent)
-  [TikTokDisconnectedEvent](#TikTokDisconnectedEvent)
-  [TikTokGiftBroadcastEvent](#TikTokGiftBroadcastEvent)
-  [TikTokUnhandledControlEvent](#TikTokUnhandledControlEvent)
-  [TikTokEvent](#TikTokEvent)


Process finished with exit code 0


<br><br>

## Contributing
Your improvements are welcome! Feel free to open an <a href="https://github.com/zerodytrash/TikTok-Live-Connector/issues">issue</a> or <a href="https://github.com/zerodytrash/TikTok-Live-Connector/pulls">pull request</a>.

/*
 * Copyright (c) 2023-2023 jwdeveloper jacekwoln@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.jwdeveloper.tiktok;

import io.github.jwdeveloper.tiktok.data.models.gifts.Gift;

import java.time.Duration;
import java.util.logging.Level;

public class CodeExample
{
    public static void main(String[] args)
    {
        TikTokLive.newClient("mrBeast")
                  .onGift((liveClient, event) ->
                  {
                     System.out.println("Thank you for Money!");
                  })
                  .buildAndConnect();
    }



    public static void codeExample()
    {
        TikTokLive.newClient("bangbetmenygy")
                .onGift((liveClient, event) ->
                {
                    if(event.getGift() == Gift.ROSE)
                    {
                        liveClient.getLogger().info("Rose from "+event.getUser().getDisplayName());
                        return;
                    }
                    liveClient.getLogger().info("Thank you for "+event.getGift().getName());
                })
                .onJoin((liveClient, event) ->
                {
                    liveClient.getLogger().info("Hello "+event.getUser().getDisplayName());
                })
                .onConnected((liveClient, event) ->
                {
                    liveClient.getLogger().info("Connected to live ");
                })
                .onError((liveClient, event) ->
                {
                    liveClient.getLogger().info("ERROR! "+event.getException().getMessage());
                })
                .buildAndConnect();
    }

    public static void configExample()
    {
        TikTokLive.newClient("bangbetmenygy")
                .configure((settings) ->
                {
                    settings.setHostName("bangbetmenygy"); // This method is useful in case you want change hostname later
                    settings.setClientLanguage("en"); // Language
                    settings.setTimeout(Duration.ofSeconds(2)); // Connection timeout
                    settings.setLogLevel(Level.ALL); // Log level
                    settings.setPrintToConsole(true); // Printing all logs to console even if log level is Level.OFF
                    settings.setHandleExistingEvents(true); // Invokes all TikTok events that had occurred before connection
                    settings.setRetryOnConnectionFailure(true); // Reconnecting if TikTok user is offline
                    settings.setRetryConnectionTimeout(Duration.ofSeconds(1)); // Timeout before next reconnection

                    //Optional: Sometimes not every message from chat are send to TikTokLiveJava to fix this issue you can set sessionId
                    // documentation how to obtain sessionId https://github.com/isaackogan/TikTok-Live-Connector#send-chat-messages
                    settings.setSessionId("86c3c8bf4b17ebb2d74bb7fa66fd0000");

                    //Optional:
                    //RoomId can be used as an override if you're having issues with HostId.
                    //You can find it in the HTML for the livestream-page
                    settings.setRoomId("XXXXXXXXXXXXXXXXX");
                })
                .buildAndConnect();
    }


}
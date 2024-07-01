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
package io.github.jwdeveloper.tiktok.websocket;

import io.github.jwdeveloper.tiktok.live.LiveEventsHandler;
import org.java_websocket.WebSocket;

public class TikTokWebSocketPingingTask {
    private Thread thread;
    private boolean isRunning = false;
    private final int MAX_TIMEOUT = 250;
    private final int SLEEP_TIME = 500;

    public void run(WebSocket webSocket, long pingTaskTime) {
        stop();
        thread = new Thread(() -> pingTask(webSocket, pingTaskTime), "pinging-task");
        isRunning = true;
        thread.start();
    }

    public void stop() {
        if (thread != null)
            thread.interrupt();
        isRunning = false;
    }

    private void pingTask(WebSocket webSocket, long pingTaskTime) {
        while (isRunning) {
            try {
                if (webSocket.isOpen()) {
                    webSocket.sendPing();
                    Thread.sleep(pingTaskTime + (int) (Math.random() * MAX_TIMEOUT));
                } else
                    Thread.sleep(SLEEP_TIME);
            } catch (Exception e) {
                //TODO we should display some kind of error message
                isRunning = false;
            }
        }

    }
}
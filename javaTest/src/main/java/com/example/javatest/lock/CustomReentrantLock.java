package com.example.javatest.lock;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

public class CustomReentrantLock extends ReentrantLock {

    public Collection<Thread> getThreads(){
        return getQueuedThreads();
    }

    public Thread getOwerThread(){
        return getOwner();
    }
}
